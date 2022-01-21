package com.sitech.service;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sitech.model.User;

public interface Myservice {

	
	User getUser(int id);
	
	void addUser(int id,String name,int age);
	
	List<User> getAllUsers();
	
    void deleteUser(int id);
	
	void updateUser(int id,String name,int age);

}
