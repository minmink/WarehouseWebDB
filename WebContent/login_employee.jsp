<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� �α��� ������</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<style>
	body{
		background-image:url("css/rocket.JPG");
	}
</style>
</head>
<body>
	<article class="main">
		<section>
			<table width="80%"  align="center"  >
			<caption class="caption">���� �α���</caption>
			<thead>
				<tr align="center"><td>${elmsg}</td></tr>
			</thead>
			<tbody id="content">
				<form action="login_employee.do?action=LOGIN" method="POST">
					<tr align="center"><td>ID : </td><td><input type="text" name="id" /></td></tr>
					<tr align="center"><td>PW : </td><td><input type="password" name="password"/></td></tr>	
					<tr align="center"><td><input type="submit" value="�α���"/></td><td><input type="reset" value="�ʱ�ȭ"/></td></tr>
				</form>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="index.html">���� ��������</a>
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>