
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
       price start
       ============================ -->
<section id="price">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block ">

                    <h1 class="heading wow fadeInUp carte-titre" data-wow-duration="300ms" data-wow-delay="300ms">La <span>Carte</span> </h1>
                    <div class="pricing-list ">


                        <c:forEach items="${cat}" var="cate">
                            <div class="title categorie-carte">
                                <h3><span>${cate.nom}</span></h3>
                            </div>
                            <c:forEach items="${cate.sousCategories}" var="ssCate">

                                <div class="title souscategorie-carte">
                                    <h4>${ssCate.nom} </h4>
                                </div>

                                <ul>
                                    <c:forEach items="${ssCate.articles}" var="article">

                                        <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                            <div class="item ">
                                                <div class="item-title ">
                                                    <h2 class="nomarticle">${article.nom}</h2>
                                                    <div class="border-bottom"></div>
                                                    <span>${article.prixTtc} E</span>
                                                </div>
                                                <p>${article.description}</p>
                                            </div>

                                            <c:if test="${commande.statut=='en creation'}">
                                                <button class="btn btn-success" onclick="addArticle('header', '${article.id}');
                                                        sendOrder('${sessionScope.cleCommande}');"><span class="glyphicon  glyphicon-shopping-cart"></span> Commander</button>
                                            </c:if>
                                        </li>
                                    </c:forEach>
                                </ul>

                            </c:forEach>
                        </c:forEach>



                    </div>
                </div>
            </div><!-- .col-md-12 close -->
        </div><!-- .row close -->
    </div><!-- .containe close -->
</section><!-- #price close -->
