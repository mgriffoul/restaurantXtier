<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
    <head>
        <meta charset="UTF-8">
        <title>LoginClient</title>  
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
        <link href="salle_template/css/login.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

        <!-- Owl Carousel -->
        <link rel="stylesheet" href="client-template/css/owl.carousel.css">
        <!-- bootstrap.min css -->
        <link rel="stylesheet" href="client-template/css/bootstrap.min.css">
        <!-- Font-awesome.min css -->
        <link rel="stylesheet" href="client-template/css/font-awesome.min.css">
        <!-- Main Stylesheet -->
        <link rel="stylesheet" href="client-template/css/animate.min.css">

        <link rel="stylesheet" href="client-template/css/main.css">
        <!-- Responsive Stylesheet -->
        <link rel="stylesheet" href="client-template/css/responsive.css">

    </head>
    <body class="loginclient">
        <div class="login-form-1 carreLogclient">
            <div class="iconeuser">
                <div class="glyphicon  glyphicon-user "></div>
                <div class="glyphicon glyphicon-resize-horizontal"></div>
                <div class="glyphicon glyphicon-shopping-cart"></div>
            </div>

            <div class="titre-connexionclient">
                <p>Selectionnez l'emplacement auquel</p><p> vous souhaitez connecter l'appareil</p>
            </div>

            <form id="login-form " class="text-left liste-commande" action="index" method="GET">

                <input type="hidden" name="section" value="logincomclient">

                <select class="form-control " name="com">
                    <option value="0" selected></option>
                    <c:forEach items="${commandes}" var="co">
                        <option value="${co.key}">
                           Emplacement : ${co.key} [tables : <c:forEach items="${co.value.emplacements}" var="emp">${emp.numero}/</c:forEach>]
                            </option>
                    </c:forEach>
                </select>
                <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                <c:if test="${empty commandes}"> Aucun emplacement n'est associée à une commande en cours </c:if>
                <label class="erreur">${message}</label>

            </form>
        </div>
        <script src="js/login.js"></script> 
    </body>
</html>
