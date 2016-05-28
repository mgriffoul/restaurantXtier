

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="cuisine-css/cuisine.css">      
        <!-- bootstrap.min css -->
        <link rel="stylesheet" href="client-template/css/bootstrap.min.css">
        <style type="text/css">body {background-color: #DCDCDC;  }</style>
        <title>JSP Cuisine</title>
    </head>
    <body>


        <div>
            <h1 align="center"><FONT size="30pt">Interface Cuisine</font></h1>
            <hr>
        </div>
        <div class="container">
            <div class="row" >

                <div class="col-md-8">

                    <center><h3>Commandes en cours</h3></center>
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
                                <c:forEach items="${ligneCommandes}" var="ligne">
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
        
        <!--FOOTER -->
        <jsp:include page="include/footer.jsp" />
<!-- Js -->
        <script src="client-template/js/vendor/modernizr-2.6.2.min.js"></script>
        <!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
        <script src="client-template/js/jquery.nav.js"></script>
        <script src="client-template/js/jquery.sticky.js"></script>
        <script src="client-template/js/bootstrap.min.js"></script>
        <script src="client-template/js/plugins.js"></script>
        <script src="client-template/js/wow.min.js"></script>
        <script src="client-template/js/main.js"></script>

    </body>
</html>
