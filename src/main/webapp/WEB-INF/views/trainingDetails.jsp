<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<html>
<head>
    <title>Trainings</title>
    <spring:url value="/styles/common.css" var="mainCss"/>
    <link rel="stylesheet" type="text/css" href="${mainCss}"/>

    <spring:url value="/styles/trainings.css" var="trainingsStyle"/>
    <link rel="stylesheet" type="text/css" href="${trainingsStyle}"/>
</head>
<body>
<tag:header/>
<div class="container">
    <h1 class="border-bottom"><c:out value="${training.subject}"/></h1>
    <p>
        Date: <fmt:formatDate type="both"
                              dateStyle="short" timeStyle="short" value="${training.fromDate}"/>
        &nbsp;
        (added on <fmt:formatDate type="both"
                                  dateStyle="short" timeStyle="short" value="${training.addedOn}"/>)
    </p>
    <br>
    <br>
    <p>
    <pre class="override-font"><c:out value="${training.description}"/></pre>
    </p>
    <br>
    Domains:&nbsp;
    <h4>
        <c:forEach items="${training.domains}" var="domain">
            <c:out value="${domain.name}"/>&nbsp;
        </c:forEach>
    </h4>
    <c:if test="${not empty training.extraDetailsList}">
        <c:forEach items="${training.extraDetailsList}" var="extraDetails">
            <br>
            <h2><c:out value="${extraDetails.header}"/></h2>
            <h3><c:out value="${extraDetails.information}"/></h3>
        </c:forEach>
    </c:if>
</div>
<tag:footer/>
</body>
</html>
