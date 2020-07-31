package com.spring.menu.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuDao {

	List<MenuVo> getList(HashMap<String, Object> map);

	void setWriteMenu(HashMap<String, Object> map);

	void setDeleteMenu(HashMap<String, Object> map);

	MenuVo getSelect(HashMap<String, Object> map);

	void setUpdateMenu(HashMap<String, Object> map);

	List<MenuVo> getSelect2(HashMap<String, Object> map);


}
