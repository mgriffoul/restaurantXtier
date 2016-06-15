<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                                <td><a href="index?section=IHMCaisse&incCaisse=ticket&nCom=${com.numero}" onclick="afficherCommande('${com.numero}');
                                    return false;" class="btn">Afficher</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </c:if>        
