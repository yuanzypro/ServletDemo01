<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="orz.yy.dao.*" %>
<%@ page import="orz.yy.entity.*" %>
<%@ page import="orz.yy.impl.*" %>
<%@ page import="orz.yy.utils.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.row1{
		background-color:#E4E4F1
	}
	.row2{
		background-color:#FBD10A
	}
</style>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>员工编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>工资</td>
			<td>入职时间</td>
			<td>部门编号</td>
		</tr>
		<%
			EmpDao dao = new EmpDaoImpl();
			List<Emp> empList = dao.findAll();
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
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>