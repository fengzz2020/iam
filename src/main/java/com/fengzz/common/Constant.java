package com.fengzz.common;

/**
 * 定义一些常量
 *
 * @author Fengzz
 * @date 2022/10/1 21:49
 * <p>
 * ******* Think twice, code once. *******
 */

public interface Constant {

    Long TOKEN_EXPIRE_TIME = 2 * 60 * 60 * 1000L;

    String USER_CREATE = "/user/create";

    String USER_DELETE = "/user/delete";

    String ROLE_ADD = "/role/add";

    String ROLE_DELETE = "/role/delete";

    String USER_ADD_ROLE = "/user/roleAdd";


    String USER_AUTHENTICATE = "/user/authenticate";

    String USER_INVALIDATE = "/user/invalidate";

    String USER_ROLE_CHECK = "/user/roleCheck";

    String USER_ROLES = "/user/roles";
}
