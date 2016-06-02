<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket</title>
    </head>
    <body>
        <p>
            TICKET
            <c:if test="${not empty affcom}">
                Commande n° : ${affcom.commande.numero}
            </c:if>
        </p>
</body>
</html>
