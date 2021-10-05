<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dodaj kota</title>
	</head>
	<body>
        <h2>Dodawanie kota</h2>
        <br />
		<form:form method="POST" modelAttribute="blank">
    <table border="1">
    		<tbody>
    			<tr>
				    <td>Imię kota:</td>
					<td><form:input path="name" /></td>
					<td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="name"/></c:if></td>
				</tr>
                <tr>
					<td>Data urodzenia (20yy.mm.dd):</td>
                    <td><form:input path="dateOfBirth" /></td>
                    <td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="dateOfBirth"/></c:if></td>
                </tr>
                <tr>
                    <td>Waga:</td>
                    <td><form:input path="weight" /></td>
                    <td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="weight"/></c:if></td>
                </tr>
                <tr>
                    <td>Imię opiekuna:</td>
                    <td><form:input path="catOwner" /></td>
                    <td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="catOwner"/></c:if></td>
                </tr>
                <tr>
                <td colspan="2" align="right"><input type="submit" value="wyślij formularz" /></td>
                </tr>
            </tbody>
    </table>
    </form:form>
    <br />
	<hr />
	<a href="listakotow">Powrót do listy kotów</a><br />
	</body>

</html>