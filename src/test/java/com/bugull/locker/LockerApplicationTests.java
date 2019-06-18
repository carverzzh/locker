package com.bugull.locker;

import com.bugull.locker.entity.RoleFunctionEntity;
import com.bugull.locker.entity.RoleMenuEntity;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LockerApplicationTests {

	private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化

	@Autowired
	private WebApplicationContext wac; // 注入WebApplicationContext

//	@Autowired
//	private MockHttpSession session;// 注入模拟的http session

//	@Autowired
//	private MockHttpServletRequest request;// 注入模拟的http request

	@Test
	public void contextLoads() {
	}

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testRoleInsert() throws Exception {
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

		/*MvcResult result = mockMvc.perform(post("/role/insert").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk()) // 模拟向testRest发送get请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //预期返回值的媒体类型text/plain;charset=UTF-8
				.andReturn();	// 返回结果

		System.out.println(result.getResponse().getContentAsString());*/

		System.out.println(JSONObject.toJSONString(map));





	}
}
