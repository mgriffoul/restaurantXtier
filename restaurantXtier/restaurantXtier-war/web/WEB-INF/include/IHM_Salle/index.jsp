<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Starter Template for Bootstrap</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/serveur-template.css" rel="stylesheet">
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Project name</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <c:forEach items="${listEmplacement}" var="element">
                      <a href='javascript: toggle()'>toggle</a>
                    <div class ="emp" id="${element.numero}">
                        <figure>
                            <a href="index?table=${element.numero}&section=IHMSalle">
                                <img src="images/IHM_salle/table_empty.png" alt=".." />
                            </a>
                            <figcaption><p>${element.statut}</p><p>Numéro : ${element.numero}</p></figcaption>
                        </figure>
                    </div>
                </c:forEach>
            </div>
        </div>  
        <!-- /.container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="/css/bootstrap/js/bootstrap.min.js"></script>
       <a href='javascript: toggle()'>toggle</a>

       
<div id='div1' style='display:none'>
Don't display me
</div>

<script>
function toggle(){
    var div1 = document.getElementById('${element.numero}')
    if (div1.style.color == 'none') {
        div1.style.display = 'block'
    } else {
        div1.style.display = 'none'
    }
}
</script>
    </body>
</html>
