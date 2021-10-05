<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista kotów</title>
	</head>
	<body>
	<h1><strong>${msg}</strong></h1>
	<br />
	<h2>Lista kotów:</h2>
			<table border="1">
			<thead>
				<tr>
					<th>#</th>
					<th>Link do kota</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${koty}" var="k">
                		<tr>
                        	<td>${k.id}</td>
				            <td><a href="kot-${k.id}">${k.name}</a></td>
				        </tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<hr />
		<a href="dodajkota">Dodaj kota</a><br />
	</body>
</html>