package com.luyunfei.erp.web.action.framework;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.luyunfei.erp.entity.base.WebConstant;
import com.luyunfei.erp.entity.framework.LoginAccount;
import com.luyunfei.erp.service.framework.AuthorityService;
import com.luyunfei.erp.web.action.base.BaseAction;
@Controller
@ParentPackage("json-default")
@Results(value={
				@Result(name="success",type="json"),
				@Result(name="framework",location="framework.jsp")
				}
		)
public class LoginAction extends BaseAction {
	@Autowired
	@Qualifier(value="authorityServiceImpl")
	private AuthorityService authorityService;
	private List<String> menuAuthorities;
	private LoginAccount loginAccount;
	private String password;
	private String loginResult;

	public LoginAccount getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(LoginAccount loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getMenuAuthorities() {
		return menuAuthorities;
	}

	public void setMenuAuthorities(List<String> menuAuthorities) {
		this.menuAuthorities = menuAuthorities;
	}
	
	public String login(){
		authorityService.validateAccount(loginAccount,password);
		if(loginAccount.getUuid()!=null){
			super.getSession().put(WebConstant.USER,loginAccount);
			success=true;
		}
		return SUCCESS;
	}
	
	public String initMenuAuthorities(){
		this.menuAuthorities=authorityService.getMenuAuthorities();
		return "framework";
	}
}
