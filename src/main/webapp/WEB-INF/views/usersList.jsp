<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${pageTitle}</title>
    <spring:url value="/styles/users.css" var="usersStyle"/>
    <link rel="stylesheet" type="text/css" href="${usersStyle}"/>

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

    <a class="button-blue" href="<c:url value="/user/add"/>">Add user</a>

    <form:form method="get" id="search-form" action="/lms/user/search">
        <input class="search-input col-1-3" name="searchTerm" placeholder="Search by name..."
               <c:if test="${not empty searchTerm}">value="${searchTerm}"</c:if>
        />
        <select id="department" name="department" class="col-1-4 department">
            <option value="0">Any department</option>
            <c:forEach items="${departments}" var="department">
                <option value="${department.id}">${department.name}</option>
            </c:forEach>
        </select>
        <input type="submit" class="col-1-10 button-blue" id="search-button" value="Search">
    </form:form>

    <c:choose>
        <c:when test="${not empty users}">

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
                    <div class="cell">
                        <%--Empty tag for add training--%>
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
                            <div class="cell">
                                <a href="<c:url value="/user/add-training/${user.id}"/>">Add training</a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <p class="col-1-1">
                No results found
            </p>
        </c:otherwise>
    </c:choose>
</div>

<tag:footer/>
<script>
    if (${not empty selectedDepartment}) {
        document.getElementById('department').value = ${selectedDepartment};
    }
</script>
</body>
</html>
