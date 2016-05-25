

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" language="javascript">
<!-- Debut
  function pleinEcran(nURL) {
  window.open(nURL,"", "fullscreen=yes, scrollbars=auto");
}
// Fin -->
</script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Cuisine</title>
    </head>
    <body>
        <div>
            <a href="#" onClick="pleinEcran('http://localhost:8080/restaurantXtier-war/index?lg_password=1111&section=login');">Mode plein écran</a> 
        </div>
        <div>
            <h1>Interface Cuisine</h1>
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
                    <td>${ligne.commande.numero}</td>
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
    </body>
</html>
