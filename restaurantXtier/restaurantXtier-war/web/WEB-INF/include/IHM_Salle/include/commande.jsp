<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty commande.getLignesCommandes}" >
            <h1> Commande n° ${commande.numero}</h1>
            
        
        
        </c:if>
        <c:if test="${empty commande.getLignesCommandes}" >
            La commande dest vide!!!
        </c:if>
    </body>
</html>
