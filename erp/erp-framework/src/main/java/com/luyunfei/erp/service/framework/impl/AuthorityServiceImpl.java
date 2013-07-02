package com.luyunfei.erp.service.framework.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.luyunfei.erp.dao.framework.AuthorityDao;
import com.luyunfei.erp.entity.framework.LoginAccount;
import com.luyunfei.erp.service.framework.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	@Qualifier(value="authorityDaoImpl")
	private AuthorityDao authorityDao;
	
	public void validateAccount(LoginAccount loginAccount,String password){
		authorityDao.validateAccount(loginAccount,password);
	}
	public List<String> getMenuAuthorities(){
		return authorityDao.getMenuAuthorities("");
	}
}
