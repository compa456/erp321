package com.service.impl.framework;

import java.util.List;

import com.erp.dao.framework.AuthorityDao;
import com.erp.entity.framework.LoginAccount;
import com.erp.service.framework.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService {
	
	private AuthorityDao authorityDao;

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
	
	public void validateAccount(LoginAccount loginAccount,String password){
		authorityDao.validateAccount(loginAccount,password);
	}
	public List<String> getMenuAuthorities(){
		return authorityDao.getMenuAuthorities("");
	}
}
