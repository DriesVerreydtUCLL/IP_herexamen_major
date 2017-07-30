<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="New Player Form"/>
    </jsp:include>
   
    <body>
        <%@include file="header.jsp"%>
        <main>
            <form id="playerForm" method="POST" action="${pageContext.request.contextPath}/player.htm" modelAttribute="player">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <p><label for="playerID">Player ID</label><input type="text" id="playerID" name="playerID"
                 value="${player.id}"> </p>
                <p ><label for="firstName">First name</label><input type="text" id="firstName" name="firstName"
                 value="${player.firstName}"> </p>
                <p><label for="lastName">Last name</label><input type="text" id="lastName" name="lastName"
                 value="${player.lastName}"> </p>
                <p><label for="playerNumber">Player number</label><input type="number" id="playerNumber" 
                          name="playerNumber" value="${player.playerNumber}"></p>
                <p><label for="Goals">Number of goals</label><input type="number" id="goals"  name="goals"
                 value="${player.goals}"> </p>
                <p><input type="submit" id="save" value="Save player"></p>
            </form>
        </main>
    </body>
</html>
