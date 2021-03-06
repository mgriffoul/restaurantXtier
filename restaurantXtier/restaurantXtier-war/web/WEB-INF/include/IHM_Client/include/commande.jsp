
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section id="commandes">
    <section id="price">
        <div class="container container-perso" id="#">
            <div class="row">
                <div class="col-md-12">
                    <div class="block ">

                        <h1 class="heading carte-titre">votre<span>Commande</span> </h1>
                        <c:if test="${commande.statut=='en creation'}">
                            <p>Pour valider votre commande, cliquer en bas de la page sur "je souhaite valider ma commande". Un serveur viendra finaliser la commande avec vous.</p>
                        </c:if>
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

                                                <span class="prixrecapcommande">
                                                    <fmt:formatNumber type="number" maxFractionDigits="2" value="${entree.prixTtc}" />E

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

                                                <span>
                                                    <fmt:formatNumber type="number" maxFractionDigits="2" value="${plat.prixTtc}" />E

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

                                                <span>
                                                    <fmt:formatNumber type="number" maxFractionDigits="2" value="${dessert.prixTtc}" />E

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
                                <c:forEach items="${hm.value}" var="for">
                                    <ul class="puce-recap-commande">
                                        <li class="article" >
                                            <div class="item ">
                                                <div class="item-title ">
                                                    <h2 class="recap-commande-intitule">${for.key.nom}</h2>
                                                    <span>
                                                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${for.key.prixTtc}" />E

                                                        <button type="button" class="btn btn-danger btn-sm " onclick="suppFormule('commandes', '${hm.key}');
                                                                suppFormule('header', '${hm.key}');
                                                                sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                                    </span>
                                                    <div class="border-bottom-perso"></div>
                                                </div>
                                            </div>
                                            <c:forEach items="${for.value}" var="ligne">
                                                <ul class="ulperso">
                                                    <li class="article" >
                                                        <div class="item ">
                                                            <div class="item-title ">
                                                                <h2 class="recap-commande-intitule"> ${ligne.article.nom}</h2>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </c:forEach>
                                        </li>
                                    </ul>
                                </c:forEach>
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

                                                <span>
                                                    <fmt:formatNumber type="number" maxFractionDigits="2" value="${boi.prixTtc}" />E

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

                            <div class="prix-total-commande">Total de votre commande : <span>
                                    <fmt:formatNumber type="number" maxFractionDigits="2" value="${prixTotal}" />E
                                </span></div>
                                <c:if test="${commande.statut=='en creation'}">
                                <a href="#"  class="btn btn-success " type="button" onclick="testbootbox('${sessionScope.cleCommande}','${sessionScope.codeServeur}');" >Je souhaite valider ma commande</a>
                             
                            </c:if>

                        </div>
                    </div>
                </div><!-- .col-md-12 close -->
            </div><!-- .row close -->
        </div><!-- .containe close -->
    </section><!-- #price close -->
</section>