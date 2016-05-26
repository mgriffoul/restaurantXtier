<%-- 
    Document   : index
    Created on : 25 mai 2016, 11:45:45
    Author     : cdi211
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interface Caisse</title>
    </head>
    <body>
        <h1>${titre}</h1>
        <div>
        <c:if test="${empty commande }" >
        Aucune commande n'est prête à être réglée.
    </c:if>
   <c:if test="${not empty commande }" >
        
            <thead>
            <tr>
                <th>Emplacement</th>
                <th>Numéro Commande</th>        
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${commande}" var="l">
                <tr>
                    <td>${l.emplacements.numero}</td>
                    <td>${l.numero}</td>
                </tr>
            </c:forEach>
        </tbody>
        </div>
        <div></div>
        <div></div>
   </c:if>
        
    </body>
</html>
