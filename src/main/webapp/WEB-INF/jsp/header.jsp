<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav>
         <ul>
            <li><a href="${pageContext.request.contextPath}/index.htm">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/player.htm">Overview</a></li>
            <li><a href="${pageContext.request.contextPath}/player/new.htm">New Player</a></li>
        </ul> 
    </nav>
    <h1>
		<span>Belgian Red Devils</span>
    </h1>
        <c:if test="${pageContext.request.userPrincipal.authenticated}">
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type ="submit" value="Log out">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        </c:if>   
</header>