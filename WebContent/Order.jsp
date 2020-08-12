<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ֹ��ϱ�</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<style>
	body{
		background-image:url("css/rocket.JPG");
	}
</style>
<script type="text/javascript">
function buttonclick(s) {
	alert( s+"��(��) �ֹ��߽��ϴ�.\n�ֹ� �Ϸ�� �ֹ�������� �̵��մϴ�." );
}

</script>
</head>
<body>
	<article class="main">
		<section>
			<table width="80%"  align="center"  >
			<caption class="caption">�ֹ� �ϱ�</caption>
			<thead>
				<tr align="center"><th></th><th>��ǰ�̸�</th><th>�о�</th><th>����</th><th>������</th><th>����</th><th>�ֹ�</th></tr>
			</thead>
			<tbody id="content">
				<tr align="center">${ordermsg}</tr>
				<c:forEach var="vo" items="${list}" >
					<form action="order.do?action=save" method="post">
						<tr align="center"><td><input type="hidden" name="pid" value="${vo.pid }"/></td>
						<td>${vo.name }</td>
						<td>${vo.kind }</td>
						<td>${vo.price}</td>
						<td>${vo.number }</td>
						<td><input type="number" name="number"/></td>
						<td><input type="submit" value="�ֹ�" onclick="buttonclick('${vo.name }');"/></td>
					</form>
				</c:forEach>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="CustomerIndex.jsp">���� ��������</a> 
				<a href="order.do?action=list">�ֹ� ���</a> 
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>