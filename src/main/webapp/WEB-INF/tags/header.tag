<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
    <link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">
    <%--<spring:url value="/styles/header.css" var="header"/>--%>
    <link rel="stylesheet" type="text/css" href="/lms/styles/header.css"/>
</head>

<div class="header">

    <h1><a class="logo grey" href="<c:url value="/"/>">LMS</a></h1>
    <ul class="nav-bar">
        <li class="menu-link">
            <a href="<c:url value="/"/>">home</a>
        </li>
        <li class="menu-link">
            <a href="<c:url value="/training/all"/>">trainings</a>
        </li>
        <li class="menu-link">
            <a href="<c:url value="/user/all"/>">contacts</a>
        </li>
        <li class="menu-link">
            <a href="<c:url value="/reports"/>">Reports</a>
        </li>

        <sec:authorize var="loggedIn" access="isAuthenticated()"/>
        <li class="menu-link">
            <c:if test="${loggedIn}">
                <a href="<c:url value="/my-account"/>">My account</a>
            </c:if>
        </li>
        <li class="menu-link">
            <c:choose>
                <c:when test="${loggedIn}">
                    <a href="<c:url value="/logout"/>">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/login"/>">Login</a>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>

</div>
<c:if test="${not empty pageTitle}">
    <div class="banner">
        <div class="page-title">${pageTitle}</div>
    </div>
</c:if>

<c:if test="${not empty infoMessage}">
    <div class="message">
        <p>${infoMessage}</p>
    </div>
</c:if>

