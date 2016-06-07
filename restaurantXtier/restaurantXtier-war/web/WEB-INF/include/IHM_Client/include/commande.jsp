
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section id="price">

    <div class="container container-perso">
        <div class="row">
            <div class="col-md-12">
                <div class="block ">

                    <h1 class="heading wow fadeInUp carte-titre" data-wow-duration="300ms" data-wow-delay="300ms">votre<span>Commande</span> </h1>
                    <div class="pricing-list ">

                        <!--Affichage des entrees commandees-->
                        <c:if test="${not empty entrees}">
                            <div class="title categorie-carte">
                                <h3><span>Entrées</span></h3>
                            </div>
                        </c:if>

                        <ul class="puce-recap-commande">
                            <c:forEach items="${entrees}" var="entree">

                                <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                    <div class="item ">
                                        <div class="item-title ">
                                            <h2 class="recap-commande-intitule">${entree.article.nom}</h2>

                                            <span>${entree.prixHT} E
                                                <button type="button" class="btn btn-danger btn-sm "><div class="glyph-retirer"><span class="glyphicon glyphicon-remove "></span></div></button>
</span>

                                            <div class="border-bottom-perso"></div>
                                        </div>
                                    </div>

                                </li>

                            </c:forEach>

                        </ul>

                        <!--Affichage des plats commandees-->
                        <c:if test="${not empty plats}">
                            <div class="title categorie-carte">
                                <h3><span>Plats</span></h3>
                            </div>
                        </c:if>


                        <ul class="puce-recap-commande">
                            <c:forEach items="${plats}" var="plat">
                                <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                    <div class="item ">
                                        <div class="item-title ">
                                            <h2 class="recap-commande-intitule">${plat.article.nom}</h2>

                                            <span>${plat.prixHT} E</span>
                                            <div class="border-bottom-perso"></div>
                                        </div>
                                    </div>

                                </li>
                            </c:forEach>
                        </ul>


                        <!--Affichage des desserts commandees-->
                        <c:if test="${not empty desserts}">
                            <div class="title categorie-carte">
                                <h3><span>Desserts</span></h3>
                            </div>
                        </c:if>


                        <ul class="puce-recap-commande">
                            <c:forEach items="${desserts}" var="dessert">
                                <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                    <div class="item ">
                                        <div class="item-title ">
                                            <h2 class="recap-commande-intitule">${dessert.article.nom}</h2>

                                            <span>${dessert.prixHT} E</span>
                                            <div class="border-bottom-perso"></div>
                                        </div>
                                    </div>

                                </li>
                            </c:forEach>
                        </ul>


                        <!--Affichage des formules commandees-->                        
                        <c:if test="${not empty formules}">
                            <div class="title categorie-carte">
                                <h3><span>Formules</span></h3>
                            </div>
                        </c:if>

                        <c:forEach items="${formules}" var="for">
                            <ul>
                                <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                    <div class="item ">
                                        <div class="item-title ">
                                            <h2 class="recap-commande-intitule">${for.key.nom}</h2>

                                            <span>${for.key.prixTtc} E</span>
                                            <div class="border-bottom-perso"></div>
                                        </div>
                                    </div>

                                    <ul>
                                        <c:forEach items="${for.value}" var="ligne">

                                            <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                                <div class="item ">
                                                    <div class="item-title ">

                                                        <h2 class="recap-commande-intitule">${ligne.article.nom}</h2>

                                                    </div>
                                                </div>
                                            </li>

                                        </c:forEach>
                                    </ul>
                                </li>
                            </ul>
                        </c:forEach>



                        <!--Affichage des boissons commandees-->
                        <c:if test="${not empty boissons}">
                            <div class="title categorie-carte">
                                <h3><span>Boissons</span></h3>
                            </div>
                        </c:if>


                        <ul class="puce-recap-commande">
                            <c:forEach items="${boissons}" var="boi">
                                <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                    <div class="item ">
                                        <div class="item-title ">
                                            <h2 class="recap-commande-intitule">${boi.article.nom}</h2>

                                            <span>${boi.prixHT} E</span>
                                            <div class="border-bottom-perso"></div>
                                        </div>
                                    </div>

                                </li>
                            </c:forEach>
                        </ul>




                    </div>
                </div>
            </div><!-- .col-md-12 close -->
        </div><!-- .row close -->
    </div><!-- .containe close -->
</section><!-- #price close -->