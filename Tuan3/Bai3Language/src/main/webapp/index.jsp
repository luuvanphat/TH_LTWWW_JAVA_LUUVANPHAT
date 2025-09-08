<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Multi-language Demo</title>
</head>
<body>
<!-- Lấy ngôn ngữ từ radio button -->
<c:set var="languageCode" value="${param.radLanguageCode}" />
<c:if test="${not empty languageCode}">
    <fmt:setLocale value="${languageCode}" scope="session" />
</c:if>
<fmt:setBundle basename="resource" scope="session" />

<form method="POST">
    <table border="0">
        <tr>
            <td><fmt:message key="languageMessage" /></td>
            <td>
                <input type="radio" name="radLanguageCode" value="vi"
                       <c:if test="${languageCode == 'vi'}">checked</c:if> />
                <fmt:message key="vn" />

                <input type="radio" name="radLanguageCode" value="en"
                       <c:if test="${languageCode == 'en'}">checked</c:if> />
                <fmt:message key="en" />

                <input type="submit" value="<fmt:message key='chooseButton'/>"/>
            </td>
        </tr>
    </table>
</form>

<form method="POST">
    <table border="0">
        <tr>
            <td><fmt:message key="userName" /></td>
            <td><input type="text" name="txtUserName" /></td>
        </tr>
        <tr>
            <td><fmt:message key="pass" /></td>
            <td><input type="password" name="txtPassword" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<fmt:message key='login'/>"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
