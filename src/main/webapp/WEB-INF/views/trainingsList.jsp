<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 20-May-17
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>${pageTitle}</title>
    <spring:url value="/styles/trainings.css" var="trainingsStyle"/>
    <link rel="stylesheet" type="text/css" href="${trainingsStyle}"/>

    <spring:url value="/styles/common.css" var="common"/>
    <link rel="stylesheet" type="text/css" href="${common}"/>
</head>
<body>
<tag:header/>

<div class="container">
    <c:if test="${not empty newTrainingAdded}">
        Training
        <c:out value="${newTrainingAdded}"/>
        was added successfully.
    </c:if>

    <c:forEach items="${trainings}" var="training">
        <div class="training-box">
            <div class="grid grid-pad">
                <div class="col-10-12">
                    <h2>
                        <c:choose>
                            <c:when test="${fn:length(training.subject) > 35}">
                                ${fn:substring(training.subject, 0, 33)}...
                            </c:when>
                            <c:otherwise>
                                ${training.subject}
                            </c:otherwise>
                        </c:choose>
                    </h2>
                    <p>
                        <c:choose>
                            <c:when test="${fn:length(training.description) > 270}">
                                ${fn:substring(training.description, 0, 268)}...
                            </c:when>
                            <c:otherwise>
                                ${training.description}
                            </c:otherwise>
                        </c:choose>
                    </p>
                </div>
                <div class="col-2-12 training-date-time-box">
                    <h3 class="training-date-time"><fmt:formatDate type="both" dateStyle="short" timeStyle="short"
                                                                   value="${training.fromDate}"/></h3>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<tag:footer/>
</body>
</html>
