package com.erp.service.framework;

import java.util.List;

import com.erp.entity.framework.LoginAccount;

public interface AuthorityService {
	List<String> getMenuAuthorities();

	void validateAccount(LoginAccount loginAccount,String password);
}
