<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="title.edit"/></title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <%--binding variables--%>
    <spring:message code="create.admin.yes" var="yesVar"/>
    <spring:message code="create.admin.no" var="noVar"/>
    <spring:message code="create.submit" var="submitVar"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.js"></script>
    <script type="text/javascript">
        function check() {
            if (($('#formInputNameEdit').val()=='')||($('#formInputAgeEdit').val()=='')) {
                alert("Fill the fields");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="langRef"><a href="${pageContext.request.contextPath}/edit/form?siteLanguage=en"><spring:message code="users.lang.en"/></a>|
    <a href="${pageContext.request.contextPath}/edit/form?siteLanguage=ru"><spring:message code="users.lang.ru"/></a>
</div>
<c:url var="saveUrl" value="${pageContext.request.contextPath}/edit"/>
<div class="content">
    <form:errors path="user.*"/>
    <div class="form">
        <form:form modelAttribute="user" method="post" acceptCharset="UTF-8" action="${saveUrl}">
            <table>
                <tr><form:hidden path="id" value="${user.id}"/></tr>
                <tr>
                    <td><form:label path="name"><spring:message code="create.name"/></form:label></td>
                    <td><form:input id="formInputNameEdit" path="name" value="${user.name}"/></td>
                </tr>
                <tr>
                    <td><form:label path="age"><spring:message code="create.age"/></form:label></td>
                    <td><form:input id="formInputAgeEdit" path="age" value="${user.age}"/></td>
                </tr>
                <tr>
                    <td><form:label path="admin"><spring:message code="create.admin"/></form:label></td>
                    <td>
                        <form:select path="admin">
                            <form:option value="true" label="${yesVar}"/>
                            <form:option value="false" label="${noVar}"/>
                        </form:select>
                    </td>
                </tr>
            </table>
            <input type="submit" class="button" value="${submitVar}">
        </form:form>
    </div>
</div>
</body>
</html>
