package com.xlei.cyojcodesandbox.security;

import java.security.Permission;

public class MySecurityManager extends SecurityManager{
    /**
     * 检查所有权限
     */
    @Override
    public void checkPermission(Permission perm){
//        super.checkPermission(perm);
    }
    //检测程序是否可执行
    @Override
    public void checkExec(String cmd) {
       throw new SecurityException("checkExec权限异常"+cmd);
    }
    //检测程序是否允许读文件
    @Override
    public void checkRead(String file) {
        System.out.println(file);
        if (file.contains("E:\\FinalDesign\\cyoj-code-sandbox")){
//            return;
        }
//        throw new SecurityException("checkRead权限异常"+file);
    }
    //检测程序是否可写文件
    @Override
    public void checkWrite(String file) {
//        throw new SecurityException("checkWrite权限异常"+file);
    }
    //检测程序是否可以删除文件
    @Override
    public void checkDelete(String file) {
        throw new SecurityException("checkDelete权限异常"+file);
    }
    //程序是否可以连接网络
    @Override
    public void checkConnect(String host, int port) {
        throw new SecurityException("checkConnect权限异常"+host+":"+port);
    }
}
