<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Employee Home</title>
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
			<caption class="caption">���� Ȩ������</caption>
			<thead>
				<tr align="center"><th><Input type="button" value="�԰��ϱ�" onclick="location.href='work.do?action=waitinglist'"/></th></tr>
				<tr align="center"><th><Input type="button" value="����ϱ�" onclick="location.href='work.do?action=releaselist'"/></th></tr>
				<tr align="center"><th><Input type="button" value="��� ��� ����" onclick="location.href='work.do?action=productlist'"/></th></tr>
				<tr align="center"><th><Input type="button" value="�α׾ƿ�" onclick="location.href='login_employee.do?action=LOGOUT'"/></th></tr>
				<tr align="center"><th><Input type="button" value="ȸ�� Ż��" onclick="alert('ȸ�� Ż�� �ϼ̽��ϴ�.');location.href='login_employee.do?action=delete'"/></th></tr>
			</thead>
			</table>
		</section>
	</article>
</body>
</html>