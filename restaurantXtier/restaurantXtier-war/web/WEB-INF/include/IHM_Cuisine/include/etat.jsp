<%-- 
    Document   : plat
    Created on : 29 mai 2016, 14:54:41
    Author     : gantn
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="container">
    <div class="row" >

        <div class="col-md-8">

            <center><h3>Commandes en cours <b><FONT color="red">${message}</font></b></h3></center>
            <div id="Affichage"> <center><table id="tab" >
                        <thead BGCOLOR="B0C4E0">
                            <tr height="40px" align="center">
                                <td width="140px">Heure</td>
                                <td width="40px">Table</td>
                                <td width="100px">Categorie</td>
                                <td width="170px">Nom du plat</td>
                                <td width="100px">Etat</td>
                                <td width="100px">Remarque</td>
                                <td width="60px"></td>
                            </tr>
                        </thead>
                        <tbody align="center" bgcolor="F0FFF0">
                            <c:forEach items="${etat}" var="ligne">
                                <tr height="40px" align="center">
                                    <td ><fmt:formatDate value="${ligne.commande.date}" pattern="hh:mm" /></td>
                                    <td class="ecart"><c:forEach items="${ligne.commande.emplacements}" var="emp">
                                            ${emp.numero}.
                                        </c:forEach></td>
                                    <td >${ligne.article.sousCategorie.categorie.nom}</td>
                                    <td >${ligne.article.nom}</td>
                                    <td >${ligne.etatLc.etat}</td>
                                    <td >${ligne.remarque}</td>
                                    <td ><a class="bouton13" href="index?section=IHMCuisine&inc=etat&meth=change&idLc=${ligne.id}" onclick="actualiserDiv();return false;">changer</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table></center>
            </div>
        </div>
        <div class="col-md-4">
            <center><h3>Commandes servies</h3></center>
            <div ><center><table id="tab2" >
                        <thead BGCOLOR="B0C4E0">
                            <tr height="40" align="center">
                                <td width="40px">Table</td>
                                <td width="170px">Nom du plat</td>
                                <td width="110px">Numero commande</td>
                            </tr>
                        </thead>
                        <tbody align="center" bgcolor="F0FFF0">
                            <c:forEach items="${servie}" var="ls">
                                <tr height="40px" align="center">
                                    <td class="ecart"><c:forEach items="${ls.commande.emplacements}" var="emp">
                                            ${emp.numero}.
                                        </c:forEach></td>
                                    <td >${ls.article.nom}</td>
                                    <td >${ls.commande.numero}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table></center>
            </div>
        </div>

    </div>
</div>

