<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>고객 회원가입 페이지</title>
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
			<caption class="caption">고객 회원가입</caption>
			<thead>
				<tr align="center">${csmsg}</tr>
			</thead>
			<tbody id="content">
				<form action="signup_customer.do" method="POST">
					<tr align="center"><td>이름 : </td><td><input type="text" name="name"/></tr>
					<tr align="center"><td>ID : </td><td><input type="text" name="id" /></td></tr>
					<tr align="center"><td>PW : </td><td><input type="password" name="password"/></td></tr>			
					<tr align="center"><td>나이 : </td><td><input type="number" name="age"/></td></tr>
					<tr align="center"><td>성별 : <input type="radio" id="sex1" name="sex" value="f"><label for="sex1">여</label></td>
					<td><input type="radio" id="sex2" name="sex" value="m"><label for="sex2">남</label></td></tr>
					<tr align="center"><td>주소 : </td><td><input type="text" name="address"/></td></tr>
					<tr align="center"><td><input type="submit" value="회원가입"/></td><td><input type="reset" value="초기화"/></td></tr>
				</form>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="index.html">이전 페이지로</a>
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>