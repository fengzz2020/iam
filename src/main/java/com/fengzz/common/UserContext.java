package com.fengzz.common;

/**
 * TODO
 *
 * @author Fengzz
 * @date 2022/10/1 22:55
 * <p>
 * ******* Think twice, code once. *******
 */

public class UserContext {

    private static final ThreadLocal<String> USER_CONTEXT = new ThreadLocal<>();

    public static void setToken(String token) {
        USER_CONTEXT.set(token);
    }

    public static String getToken() {
        return USER_CONTEXT.get();
    }

    public static void clearToken() {
        USER_CONTEXT.remove();
    }
}
