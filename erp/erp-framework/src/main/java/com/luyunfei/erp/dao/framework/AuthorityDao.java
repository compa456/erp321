package com.luyunfei.erp.dao.framework;

import java.util.List;

import com.luyunfei.erp.entity.framework.LoginAccount;

public interface AuthorityDao {
	
	public List<String> getMenuAuthorities(String userId);

	public void validateAccount(LoginAccount loginAccount,String md5Password);
	
}
