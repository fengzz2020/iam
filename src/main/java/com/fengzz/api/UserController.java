package com.fengzz.api;


import com.fengzz.common.Constant;
import com.fengzz.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/**
 * user api
 *
 * @author Fengzz
 * @date 2022/10/1 20:55
 * <p>
 * ******* Think twice, code once. *******
 */

public class UserController extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=utf-8");
        String requestURI = req.getRequestURI();

        if (Constant.USER_CREATE.equals(requestURI)) {
            // create user
            userService.create(req.getParameter("username"), req.getParameter("password"));
        } else if (Constant.USER_DELETE.equals(requestURI)){
            // delete user
            userService.delete(req.getParameter("username"));
        } else if (Constant.USER_ADD_ROLE.equals(requestURI)) {
            // add role to user
            userService.userRoleAdd(req.getParameter("username"), req.getParameter("roleName"));
        } else if (Constant.USER_AUTHENTICATE.equals(requestURI)) {
            // authenticate
            String token = userService.authenticate(req.getParameter("username"), req.getParameter("password"));
            resp.getWriter().write("token: " + token);
        } else if (Constant.USER_INVALIDATE.equals(requestURI)) {
            // invalidate
            userService.invalidateToken(req.getParameter("token"));
        } else if (Constant.USER_ROLES.equals(requestURI)) {
            // get all user roles
            Set<String> roles = userService.getUserRoles(req.getParameter("token"));
            resp.getWriter().write("roles: " + Arrays.toString(roles.toArray()));
            return;
        } else if (Constant.USER_ROLE_CHECK.equals(requestURI)) {
            // check user role
            boolean ret = userService.checkUserRole(req.getParameter("token"), req.getParameter("roleName"));
            resp.getWriter().write("result: " + ret);
            return;
        } else {
            throw new RuntimeException("404 not found.");
        }
        resp.getWriter().write("success");
    }
}
