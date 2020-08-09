package com.spring.user.user.serviceimple;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.user.dao.UserDao;
import com.spring.user.user.service.UserService;
import com.spring.user.vo.UserVo;
@Service("userService")
public class UserServiceImplement implements UserService{
	
	@Autowired
	private UserDao userDao;  
		
	@Override
	public UserVo login(HashMap<String, Object> map) {
		
		UserVo vo = userDao.login(map);
		return vo;
	}

	

}
