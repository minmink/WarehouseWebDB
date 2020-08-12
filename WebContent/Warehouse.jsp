<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�԰�</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<style>
	body{
		background-image:url("css/rocket.JPG");
	}
</style>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
	function buttonclick(value) {
		alert("�԰� �Ϸ��߽��ϴ�.");
	}
</script>
</head>
<body>
<article class="main">
	<form action="work.do?action=warehouse" method="post">
		<section>
			<table width="80%"  align="center"  >
			<caption class="caption">�԰� �ϱ�</caption>
			<tbody id="content">
				<tr align="center"><td>��ǰ ����</td></tr>
				<tr align="center"><td><select id="product" name="wid">
				<c:forEach var="vo" items="${list}" >
					<option value="${vo.id }">${vo.pid } | ${vo.name } | ${vo.number } | ${vo.space }</option>
				</c:forEach>
				</select></td></tr>
				<tr align="center"><td>��� ����</td></tr>
				<tr align="center"><td><input type="submit" value="1-1" onclick="buttonclick('1-1');"/>
				<input type="submit" value="1-2" onclick="buttonclick('1-2');"/>
				<input type="submit" value="1-3" onclick="buttonclick('1-3');"/></td></tr>
				<tr align="center"><td><input type="submit" value="2-1" onclick="buttonclick('2-1');"/>
				<input type="submit" value="2-2" onclick="buttonclick('2-2');"/>
				<input type="submit" value="2-3" onclick="buttonclick('2-3');"/></td></tr>
				<tr align="center"><td><input type="submit" value="3-1" onclick="buttonclick('3-1');"/>
				<input type="submit" value="3-2" onclick="buttonclick('3-2');"/>
				<input type="submit" value="3-3" onclick="buttonclick('3-3');"/></td></tr>
				<tr><td><input type="hidden" name="space"/></td></tr>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="EmployeeIndex.jsp">���� ��������</a> 
				<a href="work.do?action=releaselist">����ϱ�</a>
				<a href="work.do?action=productlist">��� ���</a> 
			</td></tr>
			</table>
		</section>
	</form>
</article>
</body>
</html>