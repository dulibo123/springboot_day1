package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO {
	void insert(User user);
	User query(User queryUser);
	
}
