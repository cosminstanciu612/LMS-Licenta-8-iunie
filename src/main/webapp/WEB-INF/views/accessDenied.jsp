<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tag:header/>
<div class="container">
    <h1>Access denied</h1><br>
    <br>
    <br>
    Go to <a href="<c:url value="/"/>">Homepage</a>.<br>
    <br>
</div>
<tag:footer/>
</body>
</html>
