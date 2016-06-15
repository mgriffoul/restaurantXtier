

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
    <body onload="afficherHeure(); autoActuDiv('${ssSec}')">
        <div class="row">
            <div class="col-md-4">
                <div style="padding-left:40px">

                    <h1 align="left"><FONT size="20pt">Interface </font><b><font size="40pt" color="#FF8C00">Cuisine</font></b></h1>

                </div>
            </div>
            <div class="col-md-4" >
                <div style="padding-top: 20px; margin-left: 160px;">
                    <table style="border :2px solid black; background-color: #FF8C00;">
                        <tr>
                            <td style="padding-left: 15px;padding-right: 15px;">
                                <FONT size="10pt"><b><div id="heure"></div></b></font>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

            <div class="col-md-4" >
                <div style="margin-left: 240px; ">
                    
                    <table >
                        <tr height="90px">
                            <td style="vertical-align: middle">
                                <a class="bouton17" href=index?section=IHMCuisine&inc=${ssSec}&meth=actu onclick="actualiserDiv('${ssSec}');
                                        return false;" >Actualiser</a></td>
                        </tr>
                    </table>
                </div>

            </div>

        </div>
        <hr>
        <div class="container">
            <div class="row" >

                <c:if test="${empty ssSec }" >
                    <jsp:include page="include/accueil.jsp" />
                </c:if>
                <c:if test="${not empty ssSec }" >

                    <div id="Affichage">
                        <!--affichage jsp en fonction de la selection -->
                        <jsp:include page="${contentInc}" />


                    </div>
                </c:if>
            </div>
        </div>
        <div >

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
        <script src="cuisine-css/js/cuisine-js.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
    </body>
</html>
