<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="orz.yy.dao.*" %>
<%@ page import="orz.yy.entity.*" %>
<%@ page import="orz.yy.impl.*" %>
<%@ page import="orz.yy.utils.*" %>
<html>
	<head>
		<title>员工列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">    
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						员工列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>员工编号</td>
							<td>姓名</td>
							<td>性别</td>
							<td>年龄</td>
							<td>薪水</td>
							<td>入职时间</td>
							<td>部门编号</td>
							<td>操作</td>
						</tr>
						<%
							List<Emp> empList = 
								(List<Emp>)request.getAttribute("empList");
							for(int i = 0;i < empList.size();i++){
								Emp emp = empList.get(i);
						%>
						<tr class="row<%= i%2+1 %>">
							<td><%=emp.getEmpno() %></td>
							<td><%=emp.getEname() %></td>
							<td><%=emp.getGender() %></td>
							<td><%=emp.getAge() %></td>
							<td><%=emp.getSalary() %></td>
							<td><%=emp.getHireDate() %></td>
							<td><%=emp.getDeptno() %></td>
							<td>
								<a href="del.do?id=<%=emp.getEmpno()%>" 
								onclick="return confirm('确定删除<%=emp.getEname()%>');">删除</a>&nbsp;
								<a href="load.do?id=<%=emp.getEmpno()%>">修改</a>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					<p>
						<input type="button" class="button" 
						value="添加员工" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<%@include file="footer.jsp"%>
		</div>
	</body>
</html>
