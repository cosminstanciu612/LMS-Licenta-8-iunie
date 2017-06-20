<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 21-Apr-17
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<html>
<head>
    <title>New Training</title>
    <spring:url value="/styles/common.css" var="mainCss"/>
    <link rel="stylesheet" type="text/css" href="${mainCss}"/>
</head>
<body>
<tag:header/>
<div class="container">
    <form:form method="POST" action="/lms/training/add" commandName="trainingForm">
        <div class="table add-edit">
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="subject">Subject</form:label>
                </div>
                <div class="col-2-3">
                    <form:input path="subject"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="description">Description</form:label>
                </div>
                <div class="col-2-3 large-content">
                    <form:textarea path="description"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="fromDate" >When</form:label>
                </div>
                <div class="col-2-3">
                    <form:input path="fromDate" type="datetime-local"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="duration">Duration</form:label>
                </div>
                <div class="col-2-3">
                    <form:input path="duration"/>
                </div>
            </div>
            <div class="grid grid-pad">
                <div class="col-1-3">
                    <form:label path="domains">Domains</form:label>
                </div>
                <div class="col-2-3">

                    <form:select path="domains" items="${domains}" itemValue="id" itemLabel="name"/>
                </div>
            </div>

            <div class="grid grid-pad">
                <div class="col-1-4">
                    <input class="button-blue" type="submit" value="Submit"/>
                </div>
            </div>
        </div>
    </form:form>
</div>
<tag:footer/>
</body>
</html>