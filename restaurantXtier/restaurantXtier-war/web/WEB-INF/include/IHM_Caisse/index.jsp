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
        <div id="un">
            <c:if test="${empty commandefinie }" >
                Aucune commande n'est prête à être réglée.
            </c:if>
            <c:if test="${not empty commandefinie }" >
                <table>
                <thead>
                    <tr>
                        <th>Emplacement</th>
                        <th>Numéro Commande</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${commandefinie}" var="com">
                    <tr>
                        <td><c:forEach items="${com.emplacements}" var="emp">
                            ${emp.numero}       
                            </c:forEach>    
                            </td>
                        <td>${com.numero}</td>
                        <td><a href="Controleurs/IHMCaisseControleur" onclick="afficherCommande('${com.numero}');return false;">Afficher</a></td>
                    </tr>
                </c:forEach>
                </tbody>
                </table>
            </div>
                <div id="ticket">
                   <p>
                   ${affcom.numero}
                   </p>
                </div>
        <div></div>
    </c:if>
        <script src="js/caisse.js"></script>
</body>
</html>
