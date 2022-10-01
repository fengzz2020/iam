
package com.fengzz.db;

import com.fengzz.entity.User;
import org.eclipse.jetty.util.StringUtil;

import java.util.*;

/**
 * database
 *
 * @author Fengzz
 * @date 2022/10/1 21:33
 * <p>
 * ******* Think twice, code once. *******
 */

public class DataContainer {

    /**
     * user info
     */
    private static final Map<String, User> USERS_DATA = new HashMap<>(16);

    /**
     * user token
     */
    private static final Map<String, User> USER_TOKEN = new HashMap<>(16);

    /**
     * role data
     */
    private static final Set<String> ROLE_DATA = new HashSet<>(10);

    /**
     * each user's roles
     */
    private static  final Map<String, Set<String>> USER_ROLES = new HashMap<>(16);

    private static final DataContainer DATA_CONTAINER = new DataContainer();

    private DataContainer() {}

    public static void deleteUser(String username) {
        if (!USERS_DATA.containsKey(username)) {
            throw new RuntimeException("The username doesn't exist!");
        }
        USERS_DATA.remove(username);
    }

    public DataContainer getInstance() {
        return DATA_CONTAINER;
    }

    public static void addUser(String username, User user) {
        if (USERS_DATA.containsKey(username)) {
            throw new RuntimeException("The username already exist.");
        }
        USERS_DATA.put(username, user);
    }

    public static boolean isUserExists(String username) {
        return USERS_DATA.containsKey(username);
    }

    public static User getUser(String username) {
        return USERS_DATA.get(username);
    }

    public static void addRole2User(String username, String roleName) {
        Set<String> roles = USER_ROLES.getOrDefault(username, new HashSet<>());
        roles.add(roleName);
        USER_ROLES.put(username, roles);
    }

    public static Set<String> getUserRoles(String username) {
        return USER_ROLES.get(username);
    }


    public static boolean isRoleExist(String roleName) {
        return ROLE_DATA.contains(roleName);
    }

    public static void addRole(String roleName) {
        if (ROLE_DATA.contains(roleName)) {
            throw new RuntimeException("This role name already exist!");
        }
        ROLE_DATA.add(roleName);
    }

    public static void deleteRole(String roleName) {
        if (!ROLE_DATA.contains(roleName)) {
            throw new RuntimeException("The role name doesn't exist!");
        }
        ROLE_DATA.remove(roleName);
    }

    public static void addToken(String token, User user) {
        USER_TOKEN.put(token, user);
    }

    public static void deleteToken(String token) {
        USER_TOKEN.remove(token);
    }

    public static boolean isTokenExist(String token) {
        return USER_TOKEN.containsKey(token);
    }

    public static User getToken(String token) {
        return USER_TOKEN.get(token);
    }
}
