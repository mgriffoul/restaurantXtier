
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
                                <li><a href="index?section=ihmclient" >Accueil</a></li>
                                <li><a href="index?section=ihmclient&inc=car">La Carte</a></li>
                                <li><a href="index?section=ihmclient&inc=for">Les Formules</a></li>
                                <li>
                                    <div class="panierpers">
                                    <a href="index?section=ihmclient&inc=com">Votre commande<span>${fn:length(sessionScope.commande.lignesCommandes)}</span> </a>
                                   </div>
                                </li>


                                <li><a href="#contact-us"><button type="button" class="btn btn-danger" onclick="sendHelpServeur('${sessionScope.cleCommande}');">J'ai besoin d'aide</button></a></li>
                        </div>

                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
        </div><!-- .col-md-12 close -->
    </div><!-- .row close -->
</div><!-- .container close -->

