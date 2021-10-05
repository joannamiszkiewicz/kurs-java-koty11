<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Jeden Page</title>
	</head>
	<body>
		<h2>Wybrany kot:</h2>
<table border="1">
        			<thead>
        				<tr>
        					<th>Imie kota</th>
        					<th>Data urodzenia</th>
        					<th>Waga</th>
        					<th>Właściciel</th>
        				</tr>
        			</thead>
        			<tbody>
        			<tr>
		<td>${kot.name}</td>
		<td>${kot.dateOfBirth}</td>
		<td>${kot.weight}</td>
		<td><a href="listakotowosoby-${kot.catOwner}">${kot.catOwner}</a></td>
		<tr>
		</tbody>
</table>
<br />
<hr />
		<br />
		<a href="listakotow">Powrót na listę kotów</a><br />
		<br />
		<a href="dodajkota">Dodaj nowego kota</a><br />
	</body>
</html>