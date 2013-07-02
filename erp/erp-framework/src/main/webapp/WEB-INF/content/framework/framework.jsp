<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://lyf.framework.base/jsp/jstl/functions" prefix="lu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ERP</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/jquery-easyui/themes/default/easyui.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/jquery-easyui/themes/icon.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/jquery-easyui/demo/demo.css'/>">
<script type="text/javascript" src="<c:url value='/resources/js/jquery-easyui/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-easyui/jquery.easyui.min.js'/>"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'east',split:true" title="East" style="width:180px;">
			<ul class="easyui-tree" data-options="url:'../layout/tree_data1.json',animate:true,dnd:true"></ul>
		</div>
		<div data-options="region:'west',split:true" title="ERP管理系统" style="width:180px;">
			<div id="menuContent" class="easyui-accordion" data-options="fit:true,border:false">
				<c:if test="${lu:contains(menuAuthorities,'D9E0523DA1B729E7E040007F01000D3F')}">
					<div title="系统设置" style="padding:10px;" data-options="iconCls:'icon-search'" style="padding:10px;">
				            <ul class="easyui-tree">  
				                <li>  
				                   	<c:if test="${lu:contains(menuAuthorities,'D9E0523DA1B929E7E040007F01000D3F')}"> <span>开发人员</span>  </c:if>
				                   	<ul>  
				                        <c:if test="${lu:contains(menuAuthorities,'D9E0523DA1BA29E7E040007F01000D3F')}"><li> 模块定义 </li>  </c:if>
				                    </ul>  
				                </li> 
				                <li>  
				                	<c:if test="${lu:contains(menuAuthorities,'D9E0523DA1BB29E7E040007F01000D3F')}"> <span>系统管理员</span>  </c:if>
				                	<ul>
				                		<c:if test="${lu:contains(menuAuthorities,'D9E0523DA1BA29E7E040007F01000D3F')}"><li> 用户管理 </li>  </c:if>
				                	</ul>
				                </li> 
				            </ul> 
					</div>
				</c:if>
			</div>
		</div>
		<div data-options="region:'center'">
			<div class="easyui-tabs" data-options="fit:true,border:false">
				<div title="About" data-options="href:'../layout/_content.html'" style="padding:10px"></div>
				<div title="DataGrid" style="padding:5px">
					<table class="easyui-datagrid"
							data-options="url:'../layout/datagrid_data1.json',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="50">Status</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
</body>
</html>