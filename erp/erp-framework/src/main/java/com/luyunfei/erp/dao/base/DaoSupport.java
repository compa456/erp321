package com.luyunfei.erp.dao.base;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.luyunfei.erp.entity.base.DatabaseConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoSupport {
	private static Connection conn=null;
	
	public static Connection getConnection(){
		if(conn==null){
			DatabaseConfig databaseConfig=DatabaseConfig.init();
			ComboPooledDataSource ds=new ComboPooledDataSource();
			try {
				ds.setDriverClass(databaseConfig.getDriverClassName());
				ds.setJdbcUrl(databaseConfig.getUrl());
				ds.setUser(databaseConfig.getUserName());
				ds.setPassword(databaseConfig.getPassword());
				ds.setMaxPoolSize(databaseConfig.getMaxPoolSize());
				ds.setMinPoolSize(databaseConfig.getMinPoolSize());
				ds.setInitialPoolSize(databaseConfig.getInitialPoolSize());
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
