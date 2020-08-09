package com.spring.pds.service.typehandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class ListMapTypeHandler implements TypeHandler<Object> {

	@Override
	@SuppressWarnings("unchecked")
	public void setParameter(PreparedStatement ps, int i,
			//myBatis는 PreparedStatement 상속을 받고있다. 
			Object parameter, JdbcType jdbcType) throws SQLException {
		
		List<String> list    = (List<String>) parameter;
			
		// db 연결
		CommonsDbcpNativeJdbcExtractor extractor 
		     = new CommonsDbcpNativeJdbcExtractor();
		Connection conn = extractor.getNativeConnection(
				ps.getConnection());
		
		ArrayDescriptor desc 
		  = ArrayDescriptor.createDescriptor("FILE_ARRAY", conn); 
	
		// 파일이 선택되지 않으면 list == null
		if(list == null || list.size() == 0  ) { 
			//ps.setNull(i, Types.ARRAY); // 부적합 열 유형
			//ps.setNull(i, Types.VARCHAR);  //  wrong number or types of arguments 
			ps.setArray(i, new ARRAY(desc, conn, new String[] { null }));
			  // Cause: java.sql.SQLIntegrityConstraintViolationException: 
			  // ORA-01400: cannot insert NULL into ("SPRINGBOARD"."FILES"."FILENAME")
			//ps.setArray(i, new ARRAY(desc, conn,  new String[] { null } ));
			System.out.println(" null ");
			
			return;
		} 
		
		int	size = list.size();
		
		System.out.println(i + ":" + parameter );
		
		String[]     strings = new String[size];
		for (int j = 0; j < size; j++) {			
			strings[j] = list.get(j);
		}
		
		
		parameter = new ARRAY(desc, conn, strings);
		
		ps.setArray(i, (oracle.sql.ARRAY) parameter);
			
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		
		if( cs.wasNull() ) {
			return null;
		} else {
			return cs.getString(columnIndex);
		}
		
	}

}
