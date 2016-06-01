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
<<<<<<< HEAD
        <div class="container">
            <div class="row"> 
                <c:forEach items="${listEmplacement}" var="element">
                    <form method="get"  action="index?section=IHMSalle">
                        <label id="table_${element.numero}"><img src="images/IHM_salle/table_empty.png" alt=".." onclick="occuped(${element.numero});" /></label><input type="checkbox" id ="${element.numero}"  class="chktable">     
                        </c:forEach>
                    <input type="submit" value="ok">
                    </form>
                    </div>
                    </div>  
                    <!-- /.container -->
                    <!-- Bootstrap core JavaScript
                    ================================================== -->
                    <!-- Placed at the end of the document so the pages load faster -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
                    <script src="/css/bootstrap/js/bootstrap.min.js"></script>

                    <script  type="text/javascript">
                            function occuped(x) {
                                document.getElementById('table_' + x + '').innerHTML = '<img src="images/IHM_salle/table_occuped.png" onclick="free('+x+');"/>';
                            }
                    </script> 
                    <script  type="text/javascript">
                        function free(x) {
                             document.getElementById('table_' + x + '').innerHTML = '<img src="images/IHM_salle/table_empty.png" onclick="occuped('+x+');"/>';
                        }
                    </script> 
                    </body>
                    </html>
=======
        <jsp:include page="${contentInc}" />
        <!-- /.Page Content -->
        
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="/css/bootstrap/js/bootstrap.min.js"></script>
       <a href='javascript: toggle()'>toggle</a>

    </body>
</html>
>>>>>>> f071f04fb09bf84ae5327d44683650cb84ef3d21
