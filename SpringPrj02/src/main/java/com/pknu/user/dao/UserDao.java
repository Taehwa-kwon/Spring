package com.pknu.user.dao;

import java.util.List;

import com.pknu.user.vo.UserVo;

public interface UserDao {
	public void addUser(UserVo vo);

	public List<UserVo> getList();

	public UserVo getView(String tel);
	
	public void Del(String tel);

	//public UserVo Update(String tel,String name);
		
}
