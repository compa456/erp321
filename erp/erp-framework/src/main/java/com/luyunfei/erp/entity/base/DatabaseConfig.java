package com.luyunfei.erp.entity.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
	private static DatabaseConfig object=null;
	private String driverClassName;
	private String url;
	private String userName;
	private String password;
	private int maxPoolSize;
	private int minPoolSize;
	private int initialPoolSize;
	private int maxStatements;
	
	public static DatabaseConfig init(){
		if(object==null){
			object=new DatabaseConfig(); 
			Properties props=new Properties();
			try {
				props.load(new FileInputStream("//Users//luyunfei//Dropbox//Git//framework//src//main//resources//database.properties"));
				object.setDriverClassName(props.getProperty("driverClassName"));
				object.setUrl(props.getProperty("url"));
				object.setUserName(props.getProperty("userName"));
				object.setPassword(props.getProperty("password"));
				object.setMaxPoolSize(Integer.parseInt(props.getProperty("maxPoolSize")));
				object.setMinPoolSize(Integer.parseInt(props.getProperty("minPoolSize")));
				object.setInitialPoolSize(Integer.parseInt(props.getProperty("initialPoolSize")));
				object.setMaxStatements(Integer.parseInt(props.getProperty("maxStatements")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return object;
	}
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
	public int getMinPoolSize() {
		return minPoolSize;
	}
	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}
	public int getInitialPoolSize() {
		return initialPoolSize;
	}
	public void setInitialPoolSize(int initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}
	public int getMaxStatements() {
		return maxStatements;
	}
	public void setMaxStatements(int maxStatements) {
		this.maxStatements = maxStatements;
	}
	
}
