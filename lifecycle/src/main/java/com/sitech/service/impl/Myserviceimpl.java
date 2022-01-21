package com.sitech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitech.model.User;
import com.sitech.service.Myservice;
import com.sitech.dao.userMapper;


@Service
@Transactional(rollbackFor = { Exception.class })
public class Myserviceimpl implements Myservice {

	
	
	private final userMapper usermapper;
	
	public Myserviceimpl(userMapper usermapper) {
		this.usermapper = usermapper;
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public User getUser(int id)
	{
		return usermapper.getUser(id);
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public void addUser(int id,String name,int age)
	{
		usermapper.addUser(id, name, age);
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public List<User> getAllUsers(){
		return usermapper.getAllUsers();
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public void deleteUser(int id) {
		usermapper.deleteUser(id);
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public void updateUser(int id,String name,int age) {
		usermapper.updateUser(id, name, age);
	}
	
}
