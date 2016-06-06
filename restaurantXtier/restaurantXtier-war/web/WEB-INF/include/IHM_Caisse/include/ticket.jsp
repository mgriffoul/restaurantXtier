<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket</title>
    </head>
    <body>
        <p>
            TICKET
            <c:if test="${not empty affcom.numero}">
                Commande n° : ${affcom.numero}
                            
                <table>
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prix</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${LigneComm}" var="lc">
                            <tr>
                                <td>
                                        ${lc.nom}       
                                       
                                </td>
                                <td>${lc.prix}</td>
                                
                            </tr>
                        </c:forEach>
            </c:if>
        </p>
</body>
</html>
