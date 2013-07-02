package com.luyunfei.erp.dao.framework.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luyunfei.erp.dao.base.DaoSupport;
import com.luyunfei.erp.dao.framework.AuthorityDao;
import com.luyunfei.erp.entity.framework.LoginAccount;

public class AuthorityDaoImpl extends DaoSupport implements AuthorityDao{

	public void validateAccount(LoginAccount loginAccount,String md5Password){
		
		Connection conn=super.getConnection();
		String sql="SELECT UUID,USER_NAME FROM USER_TBL WHERE LOGIN_NAME = ? and LOGIN_PASSWORD=? ";
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginAccount.getLoginName());
			pstmt.setString(2, md5Password);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				loginAccount.setUuid(resultSet.getString("UUID"));
				loginAccount.setUserName(resultSet.getString("USER_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<String> getMenuAuthorities(String userId) {
		// TODO Auto-generated method stub
		List<String> result=new ArrayList<String>();
		Connection conn=super.getConnection();
		String sql="SELECT UUID FROM AUTHORITY WHERE AUTHORITY_TYPE_IID = 0 ";
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		try {
			pstmt = conn.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				result.add(resultSet.getString("UUID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		}
		return result;
	}

}
