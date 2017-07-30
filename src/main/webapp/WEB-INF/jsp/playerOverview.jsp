<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Player"/>
    </jsp:include>
    <body>
        <%@include file="header.jsp"%>
        <main>
            <p>Amount of players: ${fn:length(players)}</p>
            <p>Average number of goals:  ${goals}</p>
            <p> ${message} </p>
            <form method="GET" action="${pageContext.request.contextPath}/player/new.htm">
            <table id="overview">
                <thead>
                    <tr>
                        <th>Player id</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Player number</th>
                        <th>Number of goals</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="player" items="${players}">
                        <tr>
                            <td><c:out value="${player.id}"/></td>
                            <td><c:out value="${player.firstName}"/></td>
                            <td><c:out value="${player.lastName}"/></td>
                            <td><c:out value="${player.playerNumber}"/></td>
                            <td><c:out value="${player.goals}"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/player/${player.id}.htm">
                                    <img src="${pageContext.request.contextPath}/images/edit.png" height="25">
                                </a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/player/delete/${player.id}.htm">
                                    <img src="${pageContext.request.contextPath}/images/delete.jpg" height="25">
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
           
                <input type="submit" value="New Player" />
            </form>
        </main>
    </body>
</html>
