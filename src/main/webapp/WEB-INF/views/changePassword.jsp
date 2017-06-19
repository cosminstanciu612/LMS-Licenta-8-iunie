<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${pageTitle}</title>
    <spring:url value="/styles/common.css" var="common"/>
    <link rel="stylesheet" type="text/css" href="${common}"/>
    <spring:url value="/styles/password.css" var="password"/>
    <link rel="stylesheet" type="text/css" href="${password}"/>
</head>
<body>
<tag:header/>

<form:form method="POST" action="/lms/my-account/change-password" commandName="passwordChange">
    <div class="password-form">
        <div class="grid grid-pad">
            <div class="col-1-3">
                <form:label path="currentPassword">Email</form:label>
            </div>
            <div class="col-2-3">
                <form:password path="currentPassword"/>
            </div>
        </div>
        <div class="grid grid-pad">
            <div class="col-1-3">
                <form:label path="newPassword">Password</form:label>
            </div>
            <div class="col-2-3">
                <form:password path="newPassword"/>
            </div>
        </div>
        <div class="grid grid-pad">
            <div class="col-1-3">
                <form:label path="confirmPassword">Password</form:label>
            </div>
            <div class="col-2-3">
                <form:password path="confirmPassword"/>
            </div>
        </div>

        <div class="grid grid-pad">
            <div class="col-1-4">
                <input class="button-blue" type="submit" value="Login"/>
            </div>
        </div>
    </div>
</form:form>

<tag:footer/>
</body>
</html>
