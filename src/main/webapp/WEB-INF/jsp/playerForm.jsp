<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="New Player Form"/>
    </jsp:include>
    <style>
        .error {
            color: #FF0000;
        }

        .errorbox {
            background-color: #888;
            border: 2px solid #FF0000;
        }
    </style>
    <body>
        <%@include file="header.jsp"%>
        <main>
            <form:form method="POST" commandName="player" action="${pageContext.request.contextPath}/player/save.htm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <form:errors path="*" cssClass="errorbox" element="div" />
                 <p>
                    <form:label path="id">Player ID</form:label>
                    <form:input id="id" path="id" /> 
                    <form:errors path="id" cssClass="error" element="div"/></p>
                <p>
                    <form:label path="firstName">First name</form:label>
                    <form:input id="firstName" path="firstName" /> 
                    <form:errors path="firstName" cssClass="error" element="div"/></p>
                <p>
                    <form:label path="lastName">Last name</form:label>
                    <form:input id="lastName" path="lastName" />
                    <form:errors path="lastName" cssClass="error" element="div"/></p>
                <p>
                    <form:label path="playerNumber">Player number</form:label>
                    <form:input id="playerNumber" path="playerNumber" />
                    <form:errors path="playerNumber" cssClass="error" element="div"/></p>
                <p>
                    <form:label path="goals">Number of goals</form:label>
                    <form:input id="goals" path="goals" /> 
                    <form:errors path="goals" cssClass="error" element="div"/></p>
                <p><input type="submit" id="save" value="Save player"></p>
            </form:form>
        </main>
    </body>
</html>
