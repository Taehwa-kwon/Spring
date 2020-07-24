package com.pknu.menu.service.implement;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.menu.dao.MenuDao;
import com.pknu.menu.service.MenuService;
import com.pknu.menu.vo.MenuVo;

@Service("menuService")
public class MenuServiceImplement implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<MenuVo> getList(HashMap<String, Object> map) {
		List<MenuVo> menuList = menuDao.getList(map);
		return menuList;
	}

	@Override
	public void setWriteMenu(HashMap<String, Object> map) {
		menuDao.setWriteMenu(map);
		
	}

	@Override
	public void setDeleteMenu(HashMap<String, Object> map) {
		menuDao.setDeleteMenu(map);
		
	}

	@Override
	public MenuVo getSelect(HashMap<String, Object> map) {
		MenuVo Vo = menuDao.getSelect(map);
		return Vo;
	}

	@Override
	public void setUpdateMenu(HashMap<String, Object> map) {
		menuDao.setUpdateMenu(map);
		
	}

	@Override
	public List<MenuVo> getSelect2(HashMap<String, Object> map) {
		List<MenuVo> list = menuDao.getSelect2(map);
		return list;
	}



}
