

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="cuisine-css/cuisine.css">
        <title>JSP Cuisine</title>
    </head>
    <body>


        <div>
            <h1 align="center"><FONT size="30pt">Interface Cuisine</font></h1>
        </div>
        <div >
            <table style="border:1px solid black" >
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
            </table>
        </div>
        <div>
            <p><a href=""><FONT color="white">Trier par Emplacement</font></a></p>
            <p><a href=""><FONT color="white">Trier par Chronologie</font></a></p>
            <p><a href=""><FONT color="white">Trier par Plat</font></a></p>
        </div>

    </body>
</html>
