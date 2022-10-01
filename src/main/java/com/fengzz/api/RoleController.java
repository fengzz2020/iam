package com.fengzz.api;

import com.fengzz.common.Constant;
import com.fengzz.db.DataContainer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;

/**
 * TODO
 *
 * @author Fengzz
 * @date 2022/10/1 22:48
 * <p>
 * ******* Think twice, code once. *******
 */

public class RoleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        String requestURI = req.getRequestURI();
        if (Constant.ROLE_ADD.equals(requestURI)) {
            // add role
            DataContainer.addRole(req.getParameter("roleName"));
        } else if (Constant.ROLE_DELETE.equals(requestURI)){
            // delete role
            DataContainer.deleteRole(req.getParameter("roleName"));
        }
    }
}
