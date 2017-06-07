<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 21-Apr-17
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html>
<head>
    <title>New User</title>
</head>
<body>
<%--TODO: extract "/lms" in a constant--%>
<form:form method = "POST" action = "/lms/user/add" commandName="userForm">
    <table>
        <tr>
            <td><form:label path = "firstName">First name</form:label></td>
            <td><form:input path = "firstName" /></td>
        </tr>
        <tr>
            <td><form:label path = "lastName">Last name</form:label></td>
            <td><form:input path = "lastName" /></td>
        </tr>
        <tr>
            <td><form:label path = "email">Email</form:label></td>
            <td><form:input path = "email" /></td>
        </tr>
        <tr>
            <td><form:label path = "phoneNumber">Phone number</form:label></td>
            <td><form:input path = "phoneNumber" /></td>
        </tr>
        <tr>
            <td>><form:label path = "department">Department</form:label></td>
            <td>
                <form:select path="department" items="${departments}" itemValue="id" itemLabel="name" />
            </td>

            <td><form:errors path="department" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
