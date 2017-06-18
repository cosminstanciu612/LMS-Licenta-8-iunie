<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 21-Apr-17
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>New User</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <spring:url value="/styles/common.css" var="common"/>
    <link rel="stylesheet" type="text/css" href="${common}"/>

    <spring:url value="/styles/users.css" var="usersStyle"/>
    <link rel="stylesheet" type="text/css" href="${usersStyle}"/>
</head>
<body>
<tag:header/>
<%--TODO: extract "/lms" in a constant--%>
<div class="container">
    <form:form method="POST" action="/lms/user/add" commandName="userForm">
        <div class="table add-edit">
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="firstName">First name</form:label>
                </div>
                <div class="col-2-3">
                    <form:input path="firstName"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="lastName">Last name</form:label>
                </div>
                <div class="col-2-3">
                    <form:input path="lastName"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="email">Email</form:label>
                </div>
                <div class="col-2-3">
                    <form:input path="email"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="phoneNumber">Phone number</form:label>
                </div>
                <div class="col-2-3">
                    <form:input path="phoneNumber"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="department">Department</form:label>
                </div>
                <div class="col-2-3">

                    <form:select path="department" items="${departments}" itemValue="id" itemLabel="name"/>
                </div>
            </div>

            <div class="grid grid-pad">
                <div class="col-1-4">
                    <input class="button-blue" type="submit" value="Submit"/>
                </div>
            </div>
        </div>
    </form:form>
</div>
<tag:footer/>
</body>
</html>
