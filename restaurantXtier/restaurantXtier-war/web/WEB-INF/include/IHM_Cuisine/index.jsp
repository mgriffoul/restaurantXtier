

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="cuisine-css/cuisine.css">
        <link rel="stylesheet" href="client-template/css/bootstrap.min.css">
        <title>JSP Cuisine</title>
    </head>
    <body>


        <div>
            <h1 align="center"><FONT size="30pt">Interface Cuisine</font></h1>
            <hr>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-8">

                    <center><h3>Commandes en cours</h3></center>
                    <center><table class="table-bordered" >
                            <thead align="center" BGCOLOR="6699FF">
                                <tr>
                                    <td>Heure</td>
                                    <td>Table</td>
                                    <td>Categorie</td>
                                    <td>Nom du plat</td>
                                    <td>Etat</td>
                                    <td>Remarque</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody align="center" bgcolor="E6E6FA">
                                <c:forEach items="${ligneCommandes}" var="ligne">
                                    <tr height="40">
                                        <td>${ligne.commande.date}</td>
                                        <td><c:forEach items="${ligne.commande.emplacements}" var="emp">
                                                ${emp.numero}.
                                            </c:forEach></td>
                                        <td>${ligne.article.sousCategorie.categorie.nom}</td>
                                        <td>${ligne.article.nom}</td>
                                        <td>${ligne.etat}</td>
                                        <td>${ligne.remarque}</td>
                                        <td>changer etat</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table></center>

                </div>
                <div class="col-md-4">
                    <center><h3>Commandes servies</h3></center>
                    <center><table style="border:1px solid black" >
                            <thead align="center" BGCOLOR="6699FF">
                                <tr>
                                    <td>Table</td>
                                    <td>Nom du plat</td>
                                    <td>Numero commande</td>
                                </tr>
                            </thead>
                            <tbody align="center" bgcolor="E6E6FA">
                                <c:forEach items="${ligneCommandes}" var="ligne">
                                    <tr height="40">
                                        <td><c:forEach items="${ligne.commande.emplacements}" var="emp">
                                                ${emp.numero}.
                                            </c:forEach></td>
                                        <td>${ligne.article.nom}</td>
                                        <td>${ligne.commande.numero}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table></center>
                </div>
            </div>
            <div class="row"><hr></div>
            <div class="row">
                <div class="col-md-8">
                    <div class="btn-group btn-group-justified">
                        <a class="btn btn-default" href="#">Trier par Emplacement</a>
                        <a class="btn btn-default" href="#">Trier par Chronologie</a>
                        <a class="btn btn-default" href="#">Trier par Plat</a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
