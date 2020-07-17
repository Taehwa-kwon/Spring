package com.pknu.user.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.pknu.user.dao.UserDao;
import com.pknu.user.vo.UserVo;

@Component
public class UserDaoImplement implements UserDao {
	//Field
	private DataSource dataSource;   
	//DataSource는 서버에서 관리하는 리소스인 커넥션 풀을 사용할 수 있게 하는 객체로서, 서버가 시작할 때 커넥션 풀이 서버에 준비되어 있어야 합니다.
	
	// Setter
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		System.out.println("2");
	}
	
	@Override
	public void addUser(UserVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("3");
		
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO SIMPLE_MEM VALUES(?,?)" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<UserVo> getList() {
		List<UserVo> list = new ArrayList();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=dataSource.getConnection();
			String sql = " SELECT NAME, TEL FROM SIMPLE_MEM ORDER BY NAME ASC ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVo vo = new UserVo();
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public UserVo getView(String tel) {
				UserVo vo = null;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = dataSource.getConnection();
					String sql = " SELECT * FROM SIMPLE_MEM WHERE TEL = ?  " ;
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tel);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						vo = new UserVo();
						vo.setName(rs.getString("name"));
						vo.setTel(rs.getString("tel"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return vo;
	}

	@Override
	public void Del(String tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = " DELETE SIMPLE_MEM WHERE TEL = ?  " ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

	/*
	 * @Override public UserVo Update(String tel,String name) { Connection conn =
	 * null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = dataSource.getConnection(); String sql =
	 * " UPDATE SIMPLE_MEM SET NAME = ? WEHRE TEL = ? " ; pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, name); pstmt.setString(2,
	 * tel); pstmt.executeQuery(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace();
	 * 
	 * } return null; }
	 */
	
	
}
