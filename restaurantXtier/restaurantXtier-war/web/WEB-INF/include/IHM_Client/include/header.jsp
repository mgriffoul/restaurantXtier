
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!--
  Header start 
      ============================== -->

<div class="container" id="header">
    <div class="row">
        <div class="col-md-12">
            <div class="block">
                <nav class="navbar navbar-default navbar-fixed-top">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">
                                <img src="client-template/images/logo.png" alt="Logo">
                            </a>

                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right mapolice" id="top-nav">
                                <li>
                                    <a href="index?section=ihmclient"  class="btn btn-success btn-perso" type="button" >
                                        Accueil
                                    </a></li>


                                <li>
                                    <div class="dropdown dropdownperso">
                                        <button class="btn btn-success dropdown-toggle btn-perso" type="button" data-toggle="dropdown">Dropdown Example
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">HTML</a></li>
                                            <li><a href="#">CSS</a></li>
                                            <li><a href="#">JavaScript</a></li>
                                        </ul>
                                    </div>
                                </li>



                                <li>
                                    <a href="index?section=ihmclient&inc=for"  class="btn btn-success btn-perso" type="button" >
                                        Les Formules
                                    </a></li>



                                <li>
                                    <a href="index?section=ihmclient&inc=com"  class="btn btn-success btn-perso" type="button" >
                                        Votre commande (<span>${fn:length(sessionScope.commande.lignesCommandes)}</span>)
                                    </a></li>


                                
                                <li>
                                    <a href="#" onclick="sendHelpServeur('${sessionScope.cleCommande}', '${sessionScope.codeServeur}');" class="btn btn-danger btnrouge-perso" type="button" >
                                       J'ai besoin d'aide
                                    </a></li>
                                
                        
                        </div>

                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
        </div><!-- .col-md-12 close -->
    </div><!-- .row close -->
</div><!-- .container close -->

