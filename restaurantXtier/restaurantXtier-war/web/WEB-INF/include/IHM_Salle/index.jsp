<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Serveur</title>
        <!-- Bootstrap core CSS -->
        <link href="salle_template/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="salle_template/css/serveur-template.css" rel="stylesheet">
        <link rel="stylesheet" href="client-template/css/main.css">
    <body>
        <div class="navbar">
            <label id="serveur"><img src="salle_template/images/IHM_salle/barman.png" alt=".." onclick="location.href = '';" />
                <p>Serveur : ${sessionScope.user.nom} ${sessionScope.user.prenom}</p>
        </div><!--/.nav-collapse -->
        <!-- Page Content -->
        <jsp:include page="${contentInc}" />
        <!-- /Page Content -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <script src="client-template/js/jquery-3.0.0.js" type="text/javascript"></script>
        <script src="client-template/js/vendor/modernizr-2.6.2.min.js"></script>
        <script src="client-template/js/jquery.nav.js"></script>
        <script src="client-template/js/bootstrap.min.js"></script>
        <script src="client-template/js/plugins.js"></script>
        <script src="client-template/js/wow.min.js"></script>
        <script src="ajax/ajaxsalle.js"></script>
        <script src="websocket/websocketserveur.js" type="text/javascript"></script>
        <script type="text/javascript">wslogServ('${sessionScope.user.code}');</script>
        <script src="client-template/js/bootbox.js" type="text/javascript"></script>
        

