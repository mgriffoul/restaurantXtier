<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${commande.getStatut() == 'en cours'}">
    <p> Commande N° ${commande.getNumero()} créée avec succès et envoyée en cuisine! </p>
</c:if>
<c:if test="${commande.getStatut() != 'en cours'}">
    <section id="commandes">
        <section id="price">
            <div class="container container-perso" id="#">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block ">
                            <h1>Commande:</h1>
                            <div class="pricing-list ">
                                <!--Affichage des entrees commandees-->
                                <c:if test="${not empty entrees}">
                                    <h3><span>Entrées</span></h3>
                                </c:if>
                                <c:forEach items="${entrees}" var="entree">
                                    <li>
                                        <div>
                                            <h2>${entree.article.nom} <fmt:formatNumber type="number" maxFractionDigits="2" value="${entree.prixTtc}" />Euros</h2>

                                            <button class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${entree.article.id}');
                                                    suppArticle('header', '${entree.article.id}');
                                                    sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                            </span>
                                        </div>
                                    </li>

                                </c:forEach>

                                </ul>

                                <!--Affichage des plats commandees-->
                                <c:if test="${not empty plats}">
                                    <h3><span>Plats</span></h3>
                                </c:if>
                                <ul>
                                    <c:forEach items="${plats}" var="plat">
                                        <li>
                                            <h2>${plat.article.nom}  <fmt:formatNumber type="number" maxFractionDigits="2" value="${plat.prixTtc}" />Euros</h2>

                                            <span>


                                                <button type="button" class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${plat.article.id}');
                                                        suppArticle('header', '${plat.article.id}');
                                                        sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                            </span>

                                        </li>
                                    </c:forEach>
                                </ul>


                                <!--Affichage des desserts commandees-->
                                <c:if test="${not empty desserts}">
                                    <h3><span>Desserts</span></h3>
                                </c:if>
                                <ul>
                                    <c:forEach items="${desserts}" var="dessert">
                                        <li>
                                            <h2>${dessert.article.nom} <fmt:formatNumber type="number" maxFractionDigits="2" value="${dessert.prixTtc}" />Euros</h2>

                                            <span>


                                                <button type="button" class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${dessert.article.id}');
                                                                suppArticle('header', '${dessert.article.id}');
                                                                sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                            </span>
                                        </li>
                                    </c:forEach>
                                </ul>


                                <!--Affichage des formules commandees-->                        
                                <c:if test="${not empty formules}">
                                    <h3><span>Formules</span></h3>
                                </c:if>


                                <c:forEach items="${formules}" var="hm">
                                    <c:forEach items="${hm.value}" var="for">
                                        <ul>
                                            <li>
                                                <h2>${for.key.nom} <fmt:formatNumber type="number" maxFractionDigits="2" value="${for.key.prixTtc}" />Euros</h2>
                                                <span>
                                                    <button type="button" class="btn btn-danger btn-sm " onclick="suppFormule('commandes', '${hm.key}');
                                                                    suppFormule('header', '${hm.key}');
                                                                    sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                                </span>
                                                <c:forEach items="${for.value}" var="ligne">
                                                    <ul>
                                                        <li>
                                                            <h2>${ligne.article.nom}</h2>

                                                        </li>
                                                    </ul>
                                                </c:forEach>
                                            </li>
                                        </ul>
                                    </c:forEach>
                                </c:forEach>


                                <!--Affichage des boissons commandees-->
                                <c:if test="${not empty boissons}">

                                    <h3><span>Boissons</span></h3>

                                </c:if>


                                <ul>
                                    <c:forEach items="${boissons}" var="boi">
                                        <li>

                                            <h2>${boi.article.nom} <fmt:formatNumber type="number" maxFractionDigits="2" value="${boi.prixTtc}" />Euros</h2>

                                            <span>


                                                <button type="button" class="btn btn-danger btn-sm " onclick="suppArticle('commandes', '${boi.article.id}');
                                                                suppArticle('header', '${boi.article.id}');
                                                                sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon glyphicon-remove glyphpers"></span></button>
                                            </span>


                                        </li>
                                    </c:forEach>
                                </ul>

                                <div class="">
                                    <p>Total de votre commande : <fmt:formatNumber type="number" maxFractionDigits="2" value="${prixTotal}" />Euros</p>
                                </div>
                            </div>
                        </div>
                    </div><!-- .col-md-12 close -->
                </div><!-- .row close -->
            </div><!-- .containe close -->
        </section><!-- #price close -->
    </section>
    <form method="POST"  action="index">
        <input type="hidden" name="section" value="IHMSalle">
        <input type="hidden" name="inc" value="validOrder">
        <input type="hidden" name="table" value="${table}">
        <input type="submit" value="Valider cette commande" >
    </form>
</c:if>

