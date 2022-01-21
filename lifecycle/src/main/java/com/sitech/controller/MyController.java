package com.sitech.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sitech.service.Myservice;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/datalife")
@Slf4j
@Transactional(rollbackFor = {Exception.class})
public class MyController {

	private final Myservice myservice ;

	public MyController(Myservice myservice) {
		this.myservice = myservice;
	}

	@PostMapping("/user")
	@Transactional(rollbackFor = {Exception.class})
	public JSONObject getUsercontroller(@RequestBody JSONObject jsonBody) {
		log.info("askAccountList:{}", jsonBody.toString());
		String id = jsonBody.getString("id");

        int iid = Integer.parseInt(id);
		Map<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("accountlist", myservice.getUser(iid));
		bodyMap.put("rtcode", 0);
		bodyMap.put("rtmsg", "成功");
		return new JSONObject(bodyMap);
	}

	@PostMapping("/adduser")
	@Transactional(rollbackFor = {Exception.class})
	public void addUsercontroller(@RequestBody JSONObject jsonBody) {
		log.info("askAccountList:{}", jsonBody.toString());
		String id = jsonBody.getString("id");
        int iid = Integer.parseInt(id);
        String name = jsonBody.getString("name");
        int age = jsonBody.getIntValue("age");
        myservice.addUser(iid,name,age);
		Map<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("rtcode", 0);
		bodyMap.put("rtmsg", "成功");
		bodyMap.toString();
	}
	
	@PostMapping("/alluser")
	@Transactional(rollbackFor = {Exception.class})
	public JSONObject allUsercontroller() {
		Map<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("accountlist", myservice.getAllUsers());
		bodyMap.put("rtcode", 0);
		bodyMap.put("rtmsg", "成功");
		return new JSONObject(bodyMap);
	}
	
	
	@PostMapping("/deleteuser")
	@Transactional(rollbackFor = {Exception.class})
	public void deleteUsercontroller(@RequestBody JSONObject jsonBody) {
		log.info("askAccountList:{}", jsonBody.toString());
		String id = jsonBody.getString("id");
        int iid = Integer.parseInt(id);
        myservice.deleteUser(iid);
	}
	
	@PostMapping("/updateuser")
	@Transactional(rollbackFor = {Exception.class})
	public void updateUsercontroller(@RequestBody JSONObject jsonBody) {
		log.info("askAccountList:{}", jsonBody.toString());
		String id = jsonBody.getString("id");
        int iid = Integer.parseInt(id);
        String name = jsonBody.getString("name");
        int age = jsonBody.getIntValue("age");
        myservice.updateUser(iid, name, age);
	}
}
