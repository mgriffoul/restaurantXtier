
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="price">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block ">
                    <div class="messageForm">${message}</div>

                    <h1 class="heading wow fadeInUp carte-titre" data-wow-duration="300ms" data-wow-delay="300ms">Les <span>Formules</span> </h1>
                    <div class="pricing-list ">
                        <ul>
                            <c:forEach items="${for}" var="form">

                                <li class="wow fadeInUp  formule" data-wow-duration="300ms" data-wow-delay="300ms">
                                    <div class="item form">
                                        <div class="item-title ">
                                            <h2>${form.nom}</h2>
                                            <div class="border-bottom"></div>
                                            <span>${form.prixTtc} E</span>
                                        </div>

                                        <c:if test="${not empty form.entrees}">
                                            <p> Entrée au choix</p>
                                        </c:if>
                                        <c:forEach items="${form.entrees}" var="entree">

                                            ${entree.nom},
                                        </c:forEach>


                                        <c:if test="${not empty form.plats}">
                                            <p> Plat au choix</p>
                                        </c:if>
                                        <c:forEach items="${form.plats}" var="plat">
                                            ${plat.nom},
                                        </c:forEach>


                                        <c:if test="${not empty form.desserts}">
                                            <p> Dessert au choix</p>
                                        </c:if>
                                        <c:forEach items="${form.desserts}" var="dessert">
                                            ${dessert.nom},
                                        </c:forEach>


                                        <c:if test="${not empty form.boissons}">
                                            <p> Boisson au choix</p>
                                        </c:if>
                                        <c:forEach items="${form.boissons}" var="boisson">
                                            ${boisson.nom},
                                        </c:forEach>

                                    </div>
                                    <c:if test="${commande.statut=='en creation'}">
                                        <a href="index?section=ihmclient&inc=buyForm&idForm=${form.id}">
                                            <button class="btn btn-success btn-commander"><span class="glyphicon  glyphicon-shopping-cart"></span> Commander</button>
                                        </a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div><!-- .col-md-12 close -->
        </div><!-- .row close -->
    </div><!-- .containe close -->
</section><!-- #price close -->

