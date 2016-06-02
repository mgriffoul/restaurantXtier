<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Restaurant One Page HTML5 Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS
================================================ -->
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
    <body>

        <!--HEADER -->
         <jsp:include page="include/header.jsp" />

        
        <jsp:include page="${contentInc}" />

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
        <script src="websocket/websocketcommande.js"></script>
        <script src="ajax/ajaxclient.js"></script>
    </body>
</html>