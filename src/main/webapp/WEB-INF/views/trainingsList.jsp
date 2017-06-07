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

<html>
<head>
    <title>Trainings</title>
</head>
<body>
<tag:header/>


<c:if test="${not empty newTrainingAdded}">
    Training
    <c:out value="${newTrainingAdded}"/>
    was added successfully.
</c:if>

<c:forEach items="${trainings}" var="training">
    <div class="content">
        <br><a href="<c:url value="/training/${training.id}"/>"> <c:out value="${training.subject}"/> </a>
        <br><c:out value="${training.description}"/>
        <br><c:forEach items="${training.extraDetailsList}" var="extraDetails">
                <br><c:out value="${extraDetails.header}"/>
                <br><c:out value="${extraDetails.information}"/>
            </c:forEach>
        <br>
    </div>
</c:forEach>
</body>
</html>
