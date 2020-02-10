//package com.twu.biblioteca;
//
//import java.security.Permission;
//
//public class DoNotExitSystem extends SecurityManager {
//    private SecurityManager securityManager;
//
//    public DoNotExitSystem(SecurityManager securityManager) {
//        System.out.println("initialized do not exit system security manager..");
//        this.securityManager = securityManager;
//    }
//
//    public void checkExit(int statusCode) {
//        if(securityManager == null)
//            throw new RuntimeException("mocked system is exited");
//
//        securityManager.checkExit(statusCode);
//    }
//
//    public void checkPermission(Permission perm) {
//        if (securityManager != null) securityManager.checkPermission(perm);
//    }
//}