package com.xlei.cyojcodesandbox.docker;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.LogContainerResultCallback;

import java.util.List;

/**
 * docker代码沙箱示例
 */
public class DockerSandBoxDemo {
    public static void main(String[] args) throws InterruptedException {
        //获取默认的docker链接
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();
        //拉取镜像
        String image = "nginx:latest";
//        PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image);
//        PullImageResultCallback pullImageResultCallback = new PullImageResultCallback() {
//            @Override
//            public void onNext(PullResponseItem item) {
//                System.out.println("下载镜像：" + item.getStatus());
//                super.onNext(item);
//            }
//        };
//        pullImageCmd
//                .exec(pullImageResultCallback)
//                .awaitCompletion();
//        System.out.println("下载完成");
        //2. 创建容器
        CreateContainerCmd containerCmd = dockerClient.createContainerCmd(image);
        CreateContainerResponse createContainerResponse = containerCmd
                .withCmd("echo", "Hello Docker")
                .exec();
        System.out.println(createContainerResponse);
        String containerId = createContainerResponse.getId();

        //3. 查看容器状态
        ListContainersCmd listContainersCmd = dockerClient.listContainersCmd();
        List<Container> containerList = listContainersCmd.withShowAll(true).exec();
        for (Container container : containerList) {
            System.out.println("容器: " + containerId);
        }
        //4. 启动容器
        dockerClient.startContainerCmd(containerId).exec();

        //5. 查看日志
        LogContainerResultCallback containerLogCallback = new LogContainerResultCallback() {
            @Override
            public void onNext(Frame item) {
                System.out.println(item.getStreamType());
                System.out.println(containerId + "容器的日志：" + new String(item.getPayload()));
                super.onNext(item);
            }
        };
        // 6. 阻塞等待日志输出
        dockerClient.logContainerCmd(containerId)
                .withStdErr(true)
                .withStdOut(true)
                .exec(containerLogCallback)
                .awaitCompletion();//异步

        //7. 删除容器
        dockerClient.removeContainerCmd(containerId)
                .withForce(true)
                .exec();

        //8. 删除镜像
        dockerClient.removeContainerCmd(image).exec();
    }
}
