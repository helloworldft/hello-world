package org.example.asm;

/**
 * Created by heqingfu on 2020/2/22.
 */
public class SecurityChecker {
    public static boolean checkSecurity() {
        System.out.println("SecurityChecker.checkSecurity ...");
        if ((System.currentTimeMillis() & 0x1) == 0) {
            return false;
        } else {
            return true;
        }
    }
}
