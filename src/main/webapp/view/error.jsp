<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title.error"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="error">
    <h2><spring:message code="error.message.greeting"/></h2>
    <h4><spring:message code="error.message.stacktrace"/></h4>
</div>
<c:forEach items="${exception.stackTrace}" var="element">
    <c:out value="${element}"/>
</c:forEach>
</body>
</html>
