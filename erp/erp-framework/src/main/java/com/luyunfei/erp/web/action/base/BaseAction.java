package com.luyunfei.erp.web.action.base;

import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	public boolean success=false;
	@JSON
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public Map<String, Object> getSession(){
		ActionContext ctx=ActionContext.getContext();
		return ctx.getSession();
	}
}
