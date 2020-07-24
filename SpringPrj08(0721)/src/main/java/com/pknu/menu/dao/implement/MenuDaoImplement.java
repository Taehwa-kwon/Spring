package com.pknu.menu.dao.implement;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.menu.dao.MenuDao;
import com.pknu.menu.vo.MenuVo;

@Repository("menuDao")
public class MenuDaoImplement implements MenuDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MenuVo> getList(HashMap<String, Object> map) {
		
		//cursor사용 결과를 조회해서 map에 넣어준다. key value의 형태로 
		sqlSession.selectList("Menu.MenuList",map); //map에 결과를 돌려받는 의미를 말함.
		System.out.println(map);
		System.out.println(map.get("result"));
		List<MenuVo> menuList = (List<MenuVo>)map.get("result"); 
		System.out.println(menuList);
		System.out.println(menuList.get(0));
		System.out.println(menuList.get(0).getMenu_id());
		
		return menuList;
	}

	@Override
	public void setWriteMenu(HashMap<String, Object> map) {
		
		System.out.println("setWrite : "+map.toString());
		sqlSession.insert("Menu.MenuInsert",map); //값을 Mapper에 전달하는 역할을 한다.즉 MenuController에서 map.put("menu_name", vo.getMenu_name()); //key, value 
		
	}

	//Delete?menu_name=스포츠 
	@Override
	public void setDeleteMenu(HashMap<String, Object> map) {
		System.out.println("setDeleteMenu : "+map.toString());
		sqlSession.delete("Menu.MenuDelete",map);
		
	}

	@Override
	public MenuVo getSelect(HashMap<String, Object> map) {
		sqlSession.selectList("Menu.MenuSelect", map);
		List<MenuVo> menuList = (List<MenuVo>) map.get("result");
		System.out.println("getSelect : " + menuList + " < " );
		MenuVo menuVo = menuList.get(0);
		System.out.println("menuVo : " + menuVo);
		return menuVo;
	}

	@Override
	public void setUpdateMenu(HashMap<String, Object> map) {
		sqlSession.update("Menu.MenuUpdate",map);
		
		
	}

	@Override
	public List<MenuVo> getSelect2(HashMap<String, Object> map) {
		//map.put("menu_id", vo.getMenu_id()); 이걸 받아오고
		sqlSession.selectList("Menu.MenuSelect", map);
		List<MenuVo> menuList = (List<MenuVo>) map.get("result");
		
		
		return menuList;
	}

	
	
	
	

}
