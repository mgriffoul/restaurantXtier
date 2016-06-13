
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="caisse_template/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="caisse_template/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <h1>test caisse</h1>


        <h1>${titre}</h1>
        <div class="divprincipale">
            <div class="encadre">
                <div class="partiegauche">           
        <div id="afficherCommande">
            <c:import url="WEB-INF/include/IHM_Caisse/include/commandes.jsp" />
            </div>
        <div class="boutoncaisse">
            <table border="1">
                <tbody>
                    <tr>
                <input type="text" name="afficheur" class="afficheur" id="afficheur" readonly="readonly" /><br />
                    </tr>
                    <tr>
                        <td><a href="#" onclick="ajouter('7');return false;">7</a></td>
                        <td><a href="#" onclick="ajouter('8');return false;">8</a></td>
                        <td><a href="#" onclick="ajouter('9');return false;">9</a></td>
                    </tr>
                    <tr>
                        <td><a href="#" onclick="ajouter('4');return false;">4</a></td>
                        <td><a href="#" onclick="ajouter('5');return false;">5</a></td>
                        <td><a href="#" onclick="ajouter('6');return false;">6</a></td>
                    </tr>
                    <tr>
                        <td><a href="#" onclick="ajouter('1');return false;">1</a></td>
                        <td><a href="#" onclick="ajouter('2');return false;">2</a></td>
                        <td><a href="#" onclick="ajouter('3');return false;">3</a></td>
                    </tr>
                    <tr>
                        <td><a href="#" onclick="vider();return false;">C</a></td>
                        <td><a href="#" onclick="ajouter('0');return false;">0</a></td>
                        <td><a href="#" onclick="ajouter('.');return false;">.</a></td>
                    </tr>
                </tbody>
            </table>
            <div class="boutoncaisse">
                <table border="1" class="tableaux">
                    <tr>
                    <a href="#" onclick="payer('CO20160000010');return false;">CB</a>
                    
                       </tr>
                    <tr>
                    <a href="#" >Espece</a>
                    </tr>
                    <tr>
                    <a href="#" >TR</a>
                    </tr>
                </table>
            </div>
        </div>
                </div>    
        
            <div id="ticket">
                <c:import url="WEB-INF/include/IHM_Caisse/include/ticket.jsp" />
            </div>
            </div> 
            </div>
            <div></div>
        
        <script src="js/caisse.js"></script>
    </body>
</html>
