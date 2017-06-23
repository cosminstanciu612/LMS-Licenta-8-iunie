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
    <spring:url value="/styles/login.css" var="login"/>
    <link rel="stylesheet" type="text/css" href="${login}"/>
</head>
<body>
<tag:header/>
<div class="container">
    <form:form method="POST" action="/lms/login" commandName="loginForm">
        <div class="login-form">
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
                    <form:label path="password">Password</form:label>
                </div>
                <div class="col-2-3">
                    <form:password path="password"/>
                </div>
            </div>

            <div class="grid grid-pad">
                <div class="col-1-4">
                    <input class="button-blue" type="submit" value="Login"/>
                </div>
            </div>
        </div>
    </form:form>
</div>
<tag:footer/>
</body>
</html>
