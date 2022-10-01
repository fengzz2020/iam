package com.fengzz.service;

import com.fengzz.common.Constant;
import com.fengzz.db.DataContainer;
import com.fengzz.entity.User;
import com.fengzz.util.Md5Util;
import org.eclipse.jetty.util.StringUtil;

import java.util.Set;

/**
 * TODO
 *
 * @author Fengzz
 * @date 2022/10/1 21:31
 * <p>
 * ******* Think twice, code once. *******
 */

public class UserService {

    /**
     * create user
     * @param username
     * @param password
     */
    public void create(String username, String password) {
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
            throw new RuntimeException("username or password can't be blank!");
        }

        String encryptPassword = Md5Util.md5(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptPassword);
        DataContainer.addUser(username, user);
    }

    /**
     * delete user
     * @param username
     */
    public void delete(String username) {
        if (StringUtil.isBlank(username)) {
            throw new RuntimeException("username is required!");
        }
        DataContainer.deleteUser(username);
    }

    /**
     * add role to user
     * @param username
     * @param roleName
     */
    public void userRoleAdd(String username, String roleName) {
        if (StringUtil.isBlank(username) || StringUtil.isBlank(roleName)) {
            throw new RuntimeException("username or roleName can't be blank!");
        }

        if (!DataContainer.isRoleExist(roleName)) {
            throw new RuntimeException("The role doesn't exist! ");
        }

        if (!DataContainer.isUserExists(username)) {
            throw new RuntimeException("The username doesn't exist! ");
        }

        DataContainer.addRole2User(username, roleName);
    }

    /**
     * user authenticate
     * @param username
     * @param password
     */
    public String authenticate(String username, String password) {
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
            throw new RuntimeException("username or password can't be blank!");
        }
        User user = DataContainer.getUser(username);
        String encryptedPassword = Md5Util.md5(password);

        if (!encryptedPassword.equals(user.getPassword())) {
            throw new RuntimeException("username or password is not correct");
        }

        String token = Md5Util.md5(username);
        user.setTokenCreatedAt(System.currentTimeMillis());
        DataContainer.addToken(token, user);

        return token;
    }

    public void invalidateToken(String token) {
        DataContainer.deleteToken(token);
    }

    public boolean checkUserRole(String token, String roleName) {
        if (DataContainer.isTokenExist(token)) {
            throw new RuntimeException("token is invalid.");
        }
        User user = DataContainer.getToken(token);

        Long tokenCreatedAt = user.getTokenCreatedAt();
        if (Constant.TOKEN_EXPIRE_TIME.compareTo(System.currentTimeMillis() - tokenCreatedAt) < 0) {
            throw new RuntimeException("token expired.");
        }

        Set<String> userRoles = DataContainer.getUserRoles(user.getUsername());
        return userRoles.contains(roleName);
    }

    public Set<String> getUserRoles(String token) {
        if (DataContainer.isTokenExist(token)) {
            throw new RuntimeException("token is invalid.");
        }
        User user = DataContainer.getToken(token);

        Long tokenCreatedAt = user.getTokenCreatedAt();
        if (Constant.TOKEN_EXPIRE_TIME.compareTo(System.currentTimeMillis() - tokenCreatedAt) < 0) {
            throw new RuntimeException("token expired.");
        }

        Set<String> userRoles = DataContainer.getUserRoles(user.getUsername());
        return userRoles;
    }

}
