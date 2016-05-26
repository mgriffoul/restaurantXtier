<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interface Caisse</title>
    </head>
    <body>
        <h1>${titre}</h1>

            <c:if test="${empty commandefinie }" >
                Aucune commande n'est prête à être réglée.
            </c:if>
            <c:if test="${not empty commandefinie }" >
                <table>
                <thead>
                    <tr>
                        <th>Emplacement</th>
                        <th>Numéro Commande</th>        
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${commandefinie}" var="l">
                    <tr>
                        <td><c:forEach items="${l.emplacements}" var="d">
                            ${d.numero}       
                            </c:forEach>    
                            </td>
                        <td>${l.numero}</td>
                    </tr>
                </c:forEach>
                </tbody>
                </table>
        
        <div></div>
        <div></div>
    </c:if>

</body>
</html>
