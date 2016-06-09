
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="commandes">
    <section id="price">

        <div class="container container-perso" id="#">
            <div class="row">
                <div class="col-md-12">
                    <div class="block ">

                        <h1 class="heading carte-titre">votre<span>Commande</span> </h1>
                        <div class="pricing-list ">
                            <!--Affichage des entrees commandees-->
                            <c:if test="${not empty entrees}">
                                <div class="title categorie-carte">
                                    <h3><span>Entrées</span></h3>
                                </div>
                            </c:if>

                            <ul class="puce-recap-commande">
                                <c:forEach items="${entrees}" var="entree">

                                    <li class="article">
                                        <div class="item ">
                                            <div class="item-title ">
                                                <h2 class="recap-commande-intitule">${entree.article.nom}</h2>

                                                <span class="prixrecapcommande">${entree.prixHT} E

                                                    <button class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${entree.article.id}');
                                                            suppArticle('header', '${entree.article.id}');
                                                            sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>

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
                                    <li class="article">
                                        <div class="item ">
                                            <div class="item-title ">
                                                <h2 class="recap-commande-intitule">${plat.article.nom}</h2>

                                                <span>${plat.prixHT} E
                                                    <button type="button" class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${plat.article.id}');
                                                            suppArticle('header', '${plat.article.id}');
                                                            sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                                </span>
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
                                    <li class=" article">
                                        <div class="item ">
                                            <div class="item-title ">
                                                <h2 class="recap-commande-intitule">${dessert.article.nom}</h2>

                                                <span>${dessert.prixHT} E
                                                    <button type="button" class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${dessert.article.id}');
                                                            suppArticle('header', '${dessert.article.id}');
                                                            sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                                </span>
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


                            <c:forEach items="${formules}" var="hm">
                                <ul class="puce-recap-commande">
                                    <li class="article" >
                                        
                                        
                                        
                                        
                                        <c:forEach items="${hm.value}" var="for">
                                            <div class="item ">
                                                <h2 class="recap-commande-intitule">${for.key.nom}</h2>
                                                <span>
                                                    ${for.key.prix}
                                                    <button type="button" class="btn btn-danger btn-sm " onclick="suppFormule('commandes', '${for.key}');
                                                            suppFormule('header', '${for.key}');
                                                            sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                                </span>
                                                <div class="border-bottom-perso"></div>
                                            </div>
                                            <c:forEach items="${for.value}" var="ligne">
                                                ${ligne.article.nom}
                                            </c:forEach>
                                        </c:forEach>
                                        
                                        
                                    </li>
                                </ul>
                            </c:forEach>




                            <c:forEach items="${formules}" var="for">
                                <ul class="puce-recap-commande">
                                    <li class="article" >
                                        <div class="item ">
                                            <div class="item-title ">
                                                <h2 class="recap-commande-intitule">${for.value.key}</h2>

                                                <span>${for.value.key.prixTtc} E
                                                    <button type="button" class="btn btn-danger btn-sm " onclick="suppFormule('commandes', '${for.key}');
                                                            suppFormule('header', '${for.key}');
                                                            sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                                </span>
                                                <div class="border-bottom-perso"></div>
                                            </div>
                                        </div>

                                        <ul class="ulperso">
                                            <c:forEach items="${for.value.value}" var="ligne">

                                                <li class="article" >
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
                                    <li class="article" >
                                        <div class="item ">
                                            <div class="item-title ">
                                                <h2 class="recap-commande-intitule">${boi.article.nom}</h2>

                                                <span>${boi.prixHT} E
                                                    <button type="button" class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${boi.article.id}');
                                                            suppArticle('header', '${boi.article.id}');
                                                            sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                                </span>
                                                <div class="border-bottom-perso"></div>
                                            </div>
                                        </div>

                                    </li>
                                </c:forEach>
                            </ul>

                            <div class="prix-total-commande">Total de votre commande : <span>${prixTotal} E</span></div>



                        </div>
                    </div>
                </div><!-- .col-md-12 close -->
            </div><!-- .row close -->
        </div><!-- .containe close -->
    </section><!-- #price close -->
</section>