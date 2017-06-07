<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 19-Apr-17
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <spring:url value="/styles/userlist.css" var="userlist"/>
    <link rel="stylesheet" type="text/css" href="${userlist}"/>

    <spring:url value="/styles/common.css" var="common"/>
    <link rel="stylesheet" type="text/css" href="${common}"/>
</head>

<body>
<tag:header/>
<c:if test="${not empty newUserAdded}">
    User with e-mail
    <c:out value="${newUserAdded}"/>
    was added successfully.
</c:if>
<div class="container">

    <div class="table">
        <div class="row header">
            <div class="cell">
                First Name
            </div>
            <div class="cell">
                Last Name
            </div>
            <div class="cell">
                E-mail
            </div>
            <div class="cell">
                Phone Number
            </div>
            <div class="cell">
                Department
            </div>
            <div class="cell">
                <%-- Empty tag --> for the "more info" buttons --%>
            </div>
            <div class="cell">
                <%--Empty tag for edit button--%>
            </div>
            <div class="cell">
                <%--Empty tag for delete button--%>
            </div>

        </div>
        <c:forEach items="${users}" var="user">
            <c:if test="${not user.deleted}">
                <div class="row">
                    <div class="cell">
                        <c:out value="${user.firstName}"/>
                    </div>
                    <div class="cell">
                        <c:out value="${user.lastName}"/>
                    </div>
                    <div class="cell">
                        <c:out value="${user.email}"/>
                    </div>
                    <div class="cell">
                        <c:out value="${user.phoneNumber}"/>
                    </div>
                    <div class="cell">
                        <c:out value="${user.department.name}"/>
                    </div>
                    <div class="cell">
                        <a class="button-green" href="<c:url value="/user/${user.id}"/>">More info</a>
                    </div>
                    <div class="cell">
                        <a class="delete-button" href="<c:url value="/user/edit/${user.id}"/> ">
                            <img src="/img/edit-icon.png"/>
                        </a>
                    </div>
                    <div class="cell">
                        <a class="delete-button" href="<c:url value="/user/delete/${user.id}"/> ">
                            <img src="/img/delete-icon.png"/>
                        </a>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>

    <a class="bottom-right button-blue" href="<c:url value="/user/add"/>">Add user</a>
</div>
<tag:footer/>
</body>
</html>
