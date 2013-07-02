package com.luyunfei.erp.service.framework;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luyunfei.erp.entity.framework.LoginAccount;

public interface AuthorityService {
	List<String> getMenuAuthorities();

	void validateAccount(LoginAccount loginAccount,String password);
}
