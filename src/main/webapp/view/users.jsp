<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="title.users"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%--binding variables--%>
    <spring:message code="users.table.column.id" var="idVar"/>
    <spring:message code="users.table.column.name" var="nameVar"/>
    <spring:message code="users.table.column.age" var="ageVar"/>
    <spring:message code="users.table.column.date" var="dateVar"/>
    <spring:message code="users.table.column.admin" var="adminVar"/>
    <spring:message code="users.table.column.admin.yes" var="yesVar"/>
    <spring:message code="users.table.column.admin.no" var="noVar"/>
    <spring:message code="users.table.column.edit" var="editVar"/>
    <spring:message code="users.table.column.delete" var="deleteVar"/>
    <spring:message code="users.search.placeholder" var="placeholderVar"/>
    <spring:message code="users.search.button" var="buttonVar"/>
</head>
<body>
<div class="langRef"><a href="${pageContext.request.contextPath}/users?siteLanguage=en"><spring:message code="users.lang.en"/></a>|
    <a href="${pageContext.request.contextPath}/users?siteLanguage=ru"><spring:message code="users.lang.ru"/></a>
</div>
<div class="content">
    <div class="createReference">
        <a href="${pageContext.request.contextPath}/create/form"><spring:message code="users.create.ref"/></a>
    </div>
    <div class="searchByName">
        <form method="post" action="${pageContext.request.contextPath}/users/search">
            <label for="userName">
                <input type="text" placeholder="${placeholderVar}" id="userName" name="userName"/>
            </label>
            <input class="button" type="submit" value="${buttonVar}" name="Search">
        </form>
    </div>
    <div class="table">
        <display:table id="row" style="text-align:center" name="users" defaultsort="1"
                       requestURI="${pageContext.request.contextPath}"
                       pagesize="${pageContext.session.getAttribute('pages')}"
                       decorator="isr.ek0.service.DateDecorator">
            <display:column property="id" sortable="true" sortName="id" title="${idVar}"/>
            <display:column property="name" sortable="true" sortName="name" title="${nameVar}"/>
            <display:column property="age" sortable="true" sortName="age" title="${ageVar}"/>
            <display:column property="createdDate" sortable="true" sortName="createdDate" title="${dateVar}"/>
            <display:column title="${adminVar}" sortable="true" sortName="admin">
                <c:out value="${row.admin ? yesVar:noVar}"/>
            </display:column>
            <display:column title="${editVar}">
                <a href="${pageContext.request.contextPath}/edit/form?id=${row.id}">
                    <img src="${pageContext.request.contextPath}/img/edit.png"/>
                </a>
            </display:column>
            <display:column title="${deleteVar}">
                <a href="${pageContext.request.contextPath}/delete?id=${row.id}">
                    <img src="${pageContext.request.contextPath}/img/delete.png"/>
                </a>
            </display:column>
        </display:table>
    </div>
    <div class="pageRestrictions">
        <a href="${pageContext.request.contextPath}/users/5.html"><spring:message code="users.show.5"/></a>
        <a href="${pageContext.request.contextPath}/users/10.html"><spring:message code="users.show.10"/></a>
        <a href="${pageContext.request.contextPath}/users/0.html"><spring:message code="users.show.all"/></a>
    </div>
</div>
</body>
</html>
