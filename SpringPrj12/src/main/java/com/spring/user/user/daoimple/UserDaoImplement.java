package com.spring.user.user.daoimple;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.user.user.dao.UserDao;
import com.spring.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImplement implements UserDao{

	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public UserVo login(HashMap<String, Object> map) {
		
		UserVo userVo =sqlSession.selectOne("User.Login",map);
		
		return userVo;
	}

	

}
