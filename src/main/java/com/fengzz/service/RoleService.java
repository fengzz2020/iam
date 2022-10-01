package com.fengzz.service;

import com.fengzz.db.DataContainer;
import org.eclipse.jetty.util.StringUtil;

/**
 * TODO
 *
 * @author Fengzz
 * @date 2022/10/1 22:50
 * <p>
 * ******* Think twice, code once. *******
 */

public class RoleService {

    public void createRole(String name) {
        if (StringUtil.isBlank(name)) {
            throw new RuntimeException("role name is required.");
        }
        DataContainer.addRole(name);
    }
}
