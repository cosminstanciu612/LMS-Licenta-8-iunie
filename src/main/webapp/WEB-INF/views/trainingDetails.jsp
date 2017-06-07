<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 22-Apr-17
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${training.subject}</title>
</head>
<body>
<h1><c:out value="${training.subject}"/></h1>
<br>
<h3><c:out value="${training.description}"/></h3>
<c:forEach items="${training.domains}" var="domain">
    <h4><c:out value="${domain.name}"/></h4>;
</c:forEach>
<h4>
    <p>Date: <fmt:formatDate type="both"
                                           dateStyle="short" timeStyle="short" value="${training.addedOn}"/></p>
</h4>
<c:if test="${not empty training.extraDetailsList}">
    <c:forEach items="${training.extraDetailsList}" var="extraDetails">
        <br>
        <h2><c:out value="${extraDetails.header}"/></h2>
        <h3><c:out value="${extraDetails.information}"/></h3>
    </c:forEach>
</c:if>
</body>
</html>
