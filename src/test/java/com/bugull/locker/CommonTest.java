package com.bugull.locker;

import com.bugull.locker.entity.RoleEntity;
import com.bugull.locker.entity.RoleFunctionEntity;
import com.bugull.locker.entity.RoleMenuEntity;
import net.minidev.json.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @program: locker
 * @description:
 * @author: Carver Zhang
 * @create: 2019-06-12 15:26
 **/
public class CommonTest {

    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("createUser", "e728db4093414622b3c04ee3c47c3256");
        map.put("roleName", "系统管理员");
        map.put("roleCode", "admin");
        List<RoleMenuEntity> roleMenuList = new ArrayList<>();

        /** home	*/
        RoleMenuEntity home = new RoleMenuEntity("", "877f818657204e92aec2d500a1346c7d");

        /** user	*/
        RoleMenuEntity user = new RoleMenuEntity("", "55352a45438340e9bbef0651de17fd5a");
        user.getRoleFunctionList().add(new RoleFunctionEntity("66d1c0e502ad432e840d17d2df9620cc", ""));
        user.getRoleFunctionList().add(new RoleFunctionEntity("6a13d1e7727048a79febcd7b64e1b0dd", ""));
        user.getRoleFunctionList().add(new RoleFunctionEntity("72020df711a140538feb9eb210a82a9f", ""));
        user.getRoleFunctionList().add(new RoleFunctionEntity("bfd8ae2d66c244e49745ffce3e08cb7a", ""));

        /** factory	*/
        RoleMenuEntity factory = new RoleMenuEntity("", "2ce8f98d6e9c4389938835c7e1e54f99");
        factory.getRoleFunctionList().add(new RoleFunctionEntity("1997d37492eb4cd19d40c0f67b52e5f9", ""));
        factory.getRoleFunctionList().add(new RoleFunctionEntity("49bb9b7237a34d17999a96e65a5d8ab0", ""));
        factory.getRoleFunctionList().add(new RoleFunctionEntity("7581dfa17b134fc0adfad49a4fb175b4", ""));
        factory.getRoleFunctionList().add(new RoleFunctionEntity("b7d32d09214f4a68abf7a3125a0ab56a", ""));

        roleMenuList.add(home);
        roleMenuList.add(user);
        roleMenuList.add(factory);

        map.put("roleMenuList", roleMenuList);

        System.out.println(JSONObject.toJSONString(map));

        System.out.println("======================================================================================================================");
        RoleEntity role = new RoleEntity();
        role.setCreateUser("e728db4093414622b3c04ee3c47c3256");
        role.setRoleName("系统管理员");
        role.setRoleCode("admin");
        role.setRoleMenuList(roleMenuList);
        System.out.println(net.sf.json.JSONObject.fromObject(role));
    }
}
