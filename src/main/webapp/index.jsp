<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title.index"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h2>MVC</h2>
<div id="entryBanner">
    <a href="${pageContext.request.contextPath}/users">Checking users</a>
</div>
</body>
</html>
