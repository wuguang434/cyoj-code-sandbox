package com.xlei.cyojcodesandbox.security;

import java.security.Permission;

public class DenySecurityManager extends SecurityManager {
    /**
     *检查所有权限
     * @param perm
     */
    @Override
    public void checkPermission(Permission perm) {
        throw new SecurityException("权限不足"+perm.toString());
    }

}
