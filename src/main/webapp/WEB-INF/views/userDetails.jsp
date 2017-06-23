<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 21-Apr-17
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.firstName}'s Details</title>
    <spring:url value="/styles/users.css" var="users"/>
    <link rel="stylesheet" type="text/css" href="${users}"/>


    <spring:url value="/styles/common.css" var="common"/>
    <link rel="stylesheet" type="text/css" href="${common}"/>
</head>
<tag:header/>

<body>
<div class="content">
    <sec:authentication property="principal.username" var="authenticatedUser"/>
    <sec:authentication property="principal.authorities" var="authorities"/>
    <c:set var="isAdmin" value="false" />
    <c:forEach var="role" items="${authorities}">
        <c:if test="${role eq 'ROLE_ADMIN'}">
            <c:set var="isAdmin" value="true" />
        </c:if>
    </c:forEach>
    <c:if test="${authenticatedUser eq user.email || isAdmin}">this is the authenticated user</c:if>
    <div class="user-name">
        <c:out value="${user.firstName}"/>&nbsp;
        <c:out value="${user.lastName}"/>
    </div>
    <table class="user-details">
        <tr>
            <td>
                E-mail:
            </td>
            <td>
                <c:out value="${user.email}"/>
            </td>
        </tr>
        <tr>
            <td>
                Phone number:
            </td>
            <td>
                <c:out value="${user.phoneNumber}"/>
            </td>
        </tr>
        <tr>
            <td>
                Department:
            </td>
            <td>
                <c:out value="${user.department.name}"/>
            </td>
        </tr>

    </table>

    <c:if test="${not empty user.trainingsHeld}">
        <div class="subtitle">
            <c:out value="Held trainings:"/>
        </div>
        <c:forEach items="${user.trainingsHeld}" var="trainingHeld">
            <div class="training-box">
                <div class="left-border-bold green">

                </div>
                <div class="subject">
                    <a href="<c:url value="/training/${trainingHeld.id}"/>">
                        <c:out value="${trainingHeld.subject}"/>
                    </a>
                </div>
                <div class="short-description">
                    <c:set var="description" value="${trainingHeld.description}"/>
                    <c:if test="${fn:length(description) > 150}">
                        <c:set var="description" value="${fn:substring(description, 0, 150)}..."/>

                    </c:if>
                    <a href="<c:url value="/training/${trainingHeld.id}"/>">
                        <c:out value="${trainingHeld.description}"/>
                    </a>
                </div>
            </div>
        </c:forEach>
        <br>
        <br>
    </c:if>

    <c:if test="${not empty trainingsParticipated}">
        <div class="subtitle">
            <c:out value="Participated at trainings:"/>
        </div>
        <c:forEach items="${trainingsParticipated}" var="trainingParticipated">
            <div class="training-box">
                <div class="left-border-bold ">

                </div>
                <div class="subject">
                    <a href="<c:url value="/training/${trainingParticipated.id}"/>">
                        <c:out value="${trainingParticipated.subject}"/>
                    </a>
                </div>
                <div class="short-description">
                    <c:set var="description" value="${trainingParticipated.description}"/>
                    <c:if test="${fn:length(description) > 150}">
                        <c:set var="description" value="${fn:substring(description, 0, 150)}..."/>

                    </c:if>
                    <a href="<c:url value="/training/${trainingParticipated.id}"/>">
                        <c:out value="${trainingParticipated.description}"/>
                    </a>
                </div>
            </div>
        </c:forEach>

    </c:if>
    <br>
    <br>

    <%--<a href="<c:url value="/training/TESTMAIL"/>">TESTMAIL</a>--%>
</div>
</body>
</html>
