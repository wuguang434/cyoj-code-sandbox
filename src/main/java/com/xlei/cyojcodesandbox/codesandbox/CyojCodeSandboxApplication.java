package com.xlei.cyojcodesandbox.codesandbox;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@SpringBootApplication
public class CyojCodeSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyojCodeSandboxApplication.class, args);
        System.out.println("====================代码沙箱启动成功====================");
    }

}
