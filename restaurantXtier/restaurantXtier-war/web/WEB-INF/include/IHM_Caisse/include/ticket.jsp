<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <div>

            <p class="rappelCommande">
                <c:if test="${not empty affcom.numero}">
                <p class="afficherPrixTicket">
                    TICKET
                </p>
                <label>Le restaurant Restaurant</label><br />
                <p>Commande n° : ${affcom.numero}<p> 
                    <p>${date}</p>

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
                            <c:if test="${not empty lc.article.prixTtc}">
                            <fmt:formatNumber value="${lc.article.prixTtc}" type="currency" currencySymbol="€" minIntegerDigits="2" maxFractionDigits="2" />
                            
                            </c:if>
                                <c:if test="${empty lc.article.prixTtc}">
                                <fmt:formatNumber value="${prixFormule}" type="currency" currencySymbol="€" minIntegerDigits="2" maxFractionDigits="2" />
                                
                                </c:if>
                                </td>

                            </tr>
                    </c:forEach>
            </table>
            <label>Totat TTC : 
                <fmt:formatNumber value="${prixTTC}" type="currency" currencySymbol="€" minIntegerDigits="2" maxFractionDigits="2" />
                </label> 
                <p>TVA : 10%</p>
        </c:if>                       
    </p>
</div>

