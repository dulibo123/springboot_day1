package com.baizhi.service;

import com.baizhi.aspect.Log;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public void insert(User user) {
		userDAO.insert(user);
	}

	@Override
	@Log(name = "query")
	@Transactional(readOnly=true)
	public User query(User user) {
		User query = userDAO.query(user);
		System.out.println("this is query!!!");
		return query;
	}

}
