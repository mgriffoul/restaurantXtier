<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket</title>
    </head>
    <body>
        <div>

            <p class="rappelCommande">
                <c:if test="${not empty affcom.numero}">
                <p class="afficherPrixTicket">
                    TICKET
                </p>
                <label>Le restaurant Restaurant</label><br />
                Commande n° : ${affcom.numero} - ${date}

            </p>
            <p class="detailCommande">
            <table>
                <thead>
                    <tr>
                        <th>Nom Article</th>
                        <th>Prix</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${affcom.lignesCommandes}" var="lc">
                        <tr>
                            <td>
                                <c:if test="${not empty lc.article.nom}">
                                    ${lc.article.nom}
                                </c:if>
                                <c:if test="${empty lc.article.nom}">    
                                    ${nomFormule}
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${not empty lc.article.prixTtc}">${lc.article.prixTtc}</c:if>
                                <c:if test="${empty lc.article.prixTtc}">${prixFormule}</c:if>
                                </td>

                            </tr>
                    </c:forEach>
            </table>
            <label>Totat TTC <p>${prixTTC}€</p></label>               
        </c:if>                       
    </p>
</div>
</body>
</html>
