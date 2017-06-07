<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 02-Jun-17
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method = "POST" action = "/lms/user/edit/${userEdit.id}" commandName="userEdit">
    <table>
        <form:input type="hidden" path="id" value="${userEdit.id}"/>
        <tr>
            <td><form:label path = "firstName">First name</form:label></td>
            <td><form:input path = "firstName" />${userEdit.firstName}</td>
        </tr>
        <tr>
            <td><form:label path = "lastName">Last name</form:label></td>
            <td><form:input path = "lastName" />${userEdit.lastName}</td>
        </tr>
        <tr>
            <td><form:label path = "email">Email</form:label></td>
            <td><form:input path = "email" />${userEdit.email}</td>
        </tr>
        <tr>
            <td><form:label path = "phoneNumber">Phone number</form:label></td>
            <td><form:input path = "phoneNumber" />${userEdit.phoneNumber}</td>
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
<script>
    document.getElementById('editUser').getElementsByTagName('option')[${userEdit.department.id}].selected  = 'selected';
</script>
</body>
</html>
