<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="orz.yy.dao.*" %>
<%@ page import="orz.yy.entity.*" %>
<%@ page import="orz.yy.impl.*" %>
<%@ page import="orz.yy.utils.*" %>
<html>
	<head>
		<title>修改员工</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						修改员工:
					</h1>
					<%
						Emp e = (Emp)request.getAttribute("emp");
					 %>
					<form action="modify.do?id=<%=e.getEmpno()%>" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									ID:
								</td>
								<td valign="middle" align="left">
									<%=e.getEmpno()%>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" 
									name="ename" value="<%=e.getEname()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" 
									name="gender" value="<%=e.getGender()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" 
									name="age" value="<%=e.getAge()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" 
									name="salary" value="<%=e.getSalary()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									部门编号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" 
									name="deptno" value="<%=e.getDeptno()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									入职时间:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" 
									name="hireDate" value="<%=e.getHireDate()%>"/>
								</td>
								<td>
									<span>日期的输入格式为：年/月/日</span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" 
							value="提交" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
