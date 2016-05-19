<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titre}</title>
    </head>
    <body>
        <div>          
            <p>Bienvenue, nous sommes le <fmt:formatDate value="${today}" pattern="EEEE dd MMMM yyyy" />.</p>
            <p>${message}</p>
        </div>
    </body>
</html>
