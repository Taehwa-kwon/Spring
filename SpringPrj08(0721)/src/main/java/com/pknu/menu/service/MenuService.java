package com.pknu.menu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pknu.menu.vo.MenuVo;

@Service("menuService")
public interface MenuService {

	List<MenuVo> getList(HashMap<String, Object> map);

	void setWriteMenu(HashMap<String, Object> map);

	void setDeleteMenu(HashMap<String, Object> map);

	MenuVo getSelect(HashMap<String, Object> map);

	void setUpdateMenu(HashMap<String, Object> map);

	List<MenuVo> getSelect2(HashMap<String, Object> map);



}
