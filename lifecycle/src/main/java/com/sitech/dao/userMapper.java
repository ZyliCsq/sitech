package com.sitech.dao;
import com.sitech.model.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface userMapper {
	
	User getUser(@Param("id")int id);
	
	void addUser(@Param("id")int id,@Param("name")String name,@Param("age")int age);

	List<User> getAllUsers();
	
	void deleteUser(@Param("id")int id);
	
	void updateUser(@Param("id")int id,@Param("name")String name,@Param("age")int age);

}
