<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
            <jsp:param name="title" value="Error" />
    </jsp:include>

    <body>
        <main>
            <%@include file="header.jsp"%>      
                    
            <p>Er is een fout gebeurd!</p>
            <p>${errorMessage}</p>
        </main>
    </body>
</html>