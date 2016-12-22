package com.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.tools.Trace;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@Api(value = "CustomController", description = "测试接口描述", position = 3)
public class CustomController {
	/*
	 * @ApiOperation(value = "接口说明", httpMethod ="接口请求方式", response ="接口返回参数类型",
	 * notes ="接口发布说明"
	 * 
	 * @ApiParam(required = "是否必须参数", name ="参数名称", value ="参数具体描述"
	 */
	@RequestMapping(value = { "/uc/aa" })
	@ResponseBody
	@ApiOperation(value = "接口说明(测试)", httpMethod = "GET", notes = "在没有会话、没有签名的情况下，进入方法体")
	public Map<String, Object> test(HttpServletRequest request, HttpServletResponse response,
			@ApiParam(required = true, name = "name", value = "姓名") @RequestParam String name) {
		try {
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("name", "ok");
		return map;
	}

	@RequestMapping(value = { "/uc/bb" })
	@ResponseBody
	@ApiOperation(value = "接口说明(测试)", httpMethod = "GET", notes = "方法2")
	public Map<String, Object> test2(HttpServletRequest request, HttpServletResponse response,
			@ApiParam(required = true, name = "userid", value = "用户id") @RequestParam String userid) {
		try {
			System.out.println(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		return map;
	}
}
