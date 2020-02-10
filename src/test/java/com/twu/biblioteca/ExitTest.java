//package com.twu.biblioteca;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ExitTest {
//
//    @Test
//    void shouldExitIfQuitOptionIsSelected() {
//        SecurityManager securityManager = System.getSecurityManager();
//
//        try {
//            System.setSecurityManager(new DoNotExitSystem(securityManager));
//            System.exit(1);
//        } catch (Exception e) {
//            assertEquals("mocked system is exited", e.getMessage());
//        } finally {
//            System.setSecurityManager(securityManager);
//        }
//    }
//
//}
