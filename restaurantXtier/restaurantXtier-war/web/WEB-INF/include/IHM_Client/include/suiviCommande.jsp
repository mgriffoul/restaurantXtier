
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="commandes">
    <section id="price">
        <div class="container container-perso" id="#">
            <div class="row">
                <div class="col-md-12">
                    <div class="block ">

                        <h1 class="heading carte-titre">suivi de votre<span>Commande</span> </h1>

                        <div class="statutcommande"> ${statut}</div>

                        <div class="pricing-list ">
                            <!--Affichage des entrees commandees-->
                            <c:if test="${not empty entrees}">
                                <div class="title categorie-carte">
                                    <h3><span>Entrées</span></h3>
                                </div>

                                <ul class="puce-recap-commande">
                                    <c:forEach items="${entrees}" var="entree">

                                        <li class="article">
                                            <div class="item ">
                                                <div class="item-title ">
                                                    <h2 class="recap-commande-intitule">${entree.article.nom}</h2>

                                                    <span class="prixrecapcommande">${entree.prixHT} E   / ${entree.etatLc.etat}

                                                    </span>
                                                    <div class="border-bottom-perso"></div>
                                                </div>
                                            </div>

                                        </li>

                                    </c:forEach>

                                </ul>
                            </c:if>

                            <!--Affichage des plats commandees-->
                            <c:if test="${not empty plats}">
                                <div class="title categorie-carte">
                                    <h3><span>Plats</span></h3>
                                </div>



                                <ul class="puce-recap-commande">
                                    <c:forEach items="${plats}" var="plat">
                                        <li class="article">
                                            <div class="item ">
                                                <div class="item-title ">
                                                    <h2 class="recap-commande-intitule">${plat.article.nom}</h2>

                                                    <span>${plat.prixHT} E / ${plat.etatLc.etat}</span>
                                                    <div class="border-bottom-perso"></div>
                                                </div>
                                            </div>

                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>

                            <!--Affichage des desserts commandees-->
                            <c:if test="${not empty desserts}">
                                <div class="title categorie-carte">
                                    <h3><span>Desserts</span></h3>
                                </div>



                                <ul class="puce-recap-commande">
                                    <c:forEach items="${desserts}" var="dessert">
                                        <li class=" article">
                                            <div class="item ">
                                                <div class="item-title ">
                                                    <h2 class="recap-commande-intitule">${dessert.article.nom}</h2>

                                                    <span>${dessert.prixHT} E / ${dessert.etatLc.etat}
                                                    </span>
                                                    <div class="border-bottom-perso"></div>
                                                </div>
                                            </div>

                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>

                            <!--Affichage des formules commandees-->                        
                            <c:if test="${not empty formules}">
                                <div class="title categorie-carte">
                                    <h3><span>Formules</span></h3>
                                </div>


                                <ul class="puce-recap-commande">
                                    <c:forEach items="${formules}" var="hm">
                                        <c:forEach items="${hm.value}" var="for">

                                            <li class="article" >
                                                <div class="item ">
                                                    <div class="item-title ">
                                                        <h2 class="recap-commande-intitule">${for.key.nom}</h2>
                                                        <span>
                                                            ${for.key.prix}
                                                        </span>
                                                        <div class="border-bottom-perso"></div>
                                                    </div>
                                                </div>
                                                <c:forEach items="${for.value}" var="ligne">
                                                    <ul class="ulperso">


                                                        <li class="article">
                                                            <div class="item ">
                                                                <div class="item-title ">
                                                                    <h2 class="recap-commande-intitule">${ligne.article.nom}</h2>

                                                                    <span class="prixrecapcommande">${ligne.etatLc.etat}</span>

                                                                </div>
                                                            </div>

                                                        </li>


                                                    </ul>
                                                </c:forEach>
                                            </li>

                                        </c:forEach>
                                    </c:forEach>
                                </ul>
                            </c:if>


                            <!--Affichage des boissons commandees-->
                            <c:if test="${not empty boissons}">
                                <div class="title categorie-carte">
                                    <h3><span>Boissons</span></h3>
                                </div>



                                <ul class="puce-recap-commande">
                                    <c:forEach items="${boissons}" var="boi">
                                        <li class="article" >
                                            <div class="item ">
                                                <div class="item-title ">
                                                    <h2 class="recap-commande-intitule">${boi.article.nom}</h2>

                                                    <span>${boi.prixHT} E / ${boi.etatLc.etat}</span>
                                                    <div class="border-bottom-perso"></div>
                                                </div>
                                            </div>

                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>
                            
                            <div class="prix-total-commande">Total de votre commande : <span>${prixTotal} E</span></div>



                        </div>
                    </div>
                </div><!-- .col-md-12 close -->
            </div><!-- .row close -->
        </div><!-- .containe close -->
    </section><!-- #price close -->
</section>