<%-- 
    Document   : plat
    Created on : 29 mai 2016, 14:54:41
    Author     : gantn
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <div class="container">
            <div class="row" >

                <div class="col-md-8">

                    <center><h3>Commandes en cours ${message}</h3></center>
                    <center><table class="table-bordered">
                            <thead align="center" BGCOLOR="B0C4E0">
                                <tr height="40">
                                    <td class="ecart">Heure</td>
                                    <td class="ecart">Table</td>
                                    <td class="ecart">Categorie</td>
                                    <td class="ecart">Nom du plat</td>
                                    <td class="ecart">Etat</td>
                                    <td class="ecart">Remarque</td>
                                    <td class="ecart"></td>
                                </tr>
                            </thead>
                            <tbody align="center" bgcolor="F0FFF0">
                                <c:forEach items="${etat}" var="ligne">
                                    <tr height="40">
                                        <td class="ecart">${ligne.commande.date}</td>
                                        <td><c:forEach items="${ligne.commande.emplacements}" var="emp">
                                                ${emp.numero}.
                                            </c:forEach></td>
                                        <td class="ecart">${ligne.article.sousCategorie.categorie.nom}</td>
                                        <td class="ecart">${ligne.article.nom}</td>
                                        <td class="ecart">${ligne.etat}</td>
                                        <td class="ecart">${ligne.remarque}</td>
                                        <td class="ecart"><a class="bouton13" href="">changer</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table></center>

                </div>
                <div class="col-md-4">
                    <center><h3>Commandes servies</h3></center>
                    <center><table class="table-bordered" >
                            <thead align="center" BGCOLOR="B0C4E0">
                                <tr height="40">
                                    <td class="ecart">Table</td>
                                    <td class="ecart">Nom du plat</td>
                                    <td class="ecart">Numero commande</td>
                                </tr>
                            </thead>
                            <tbody align="center" bgcolor="F0FFF0">
                                <c:forEach items="${lcServies}" var="ls">
                                    <tr height="40">
                                        <td class="ecart"><c:forEach items="${ls.commande.emplacements}" var="emp">
                                                ${emp.numero}.
                                            </c:forEach></td>
                                        <td class="ecart">${ls.article.nom}</td>
                                        <td class="ecart">${ls.commande.numero}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table></center>
                </div>

            </div>
        </div>

