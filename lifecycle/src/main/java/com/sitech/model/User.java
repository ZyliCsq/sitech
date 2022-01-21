package com.sitech.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class User {

    //实体类的属性和表的字段名称一一对应
    private int id;
    private String name;
    private int age;

    private User(){
    	}
    
    public static User getInstance(int id,String name,int age) {
    	User user = new User();
    	user.setId(id);
    	user.setName(name);
    	user.setAge(age);
    	return user;
    }
    
}