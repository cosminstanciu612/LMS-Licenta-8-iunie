<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 21-Apr-17
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>New Training</title>
    <spring:url value="/styles/common.css" var="mainCss" />
    <link rel="stylesheet" type="text/css" href="${mainCss}"/>
</head>
<body>
<form:form method="POST" action="/lms/training/add" commandName="trainingForm">
    <table>
        <tr>
            <td><form:label path="subject">Subject</form:label></td>
            <td><form:input path="subject"/></td>
        </tr>
        <tr>
            <td><form:label path="fromDate">Date</form:label> </td>
            <%--<td><form:input path="fromDate" cssClass="date-picker"/></td>--%>
            <td><form:input path="fromDate" type="datetime-local"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:textarea path="description" cssClass="training-description"/></td>
        </tr>
        <tr>
            <td>><form:label path = "domains">Department</form:label></td>
            <td>
                <form:select path="domains" items="${domains}" itemValue="id" itemLabel="name" />
            </td>
            <td><form:errors path="domains" cssClass="error" /></td>

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