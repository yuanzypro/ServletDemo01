<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title>添加员工</title>
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
						 添加员工:
					</h1>
					<form action="add.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									 姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别：
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="gender" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									 年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									 部门编号：
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="deptno" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									 入职日期：
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="hireDate" />
								</td>
								<td>
									<span>日期的输入格式为：年/月/日</span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提交 " />
						</p>
					</form>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
