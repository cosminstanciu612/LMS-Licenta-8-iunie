<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 23-Apr-17
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>LMS</title>

    <spring:url value="/styles/common.css" var="common"/>
    <link rel="stylesheet" type="text/css" href="${common}"/>
</head>
<body>
<tag:header/>
<div class="green-background">
    <div class="homepage-content">
        <br>
        <br>
        <p>Learning, because you use it to deliver education courses or training programs.</p>
        <p>Management, because it helps you organize these courses.</p>
        <p>System, because it is a computer program.</p>
        <br>
        <br>
    </div>
</div>
<div class="white-background">
    <div class="homepage-content">
        <p>To be able to enter this application, you need to log in.</p>
        <a class="button-blue" href="<c:url value="/login"/>">Log in</a>
    </div>
</div>

<tag:footer/>

</body>
</html>
