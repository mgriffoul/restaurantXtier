<%-- 
    Document   : carte
    Created on : 25 mai 2016, 13:35:37
    Author     : cdi207
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
       price start
       ============================ -->
<section id="price">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block">

                    <h1 class="heading wow fadeInUp" data-wow-duration="300ms" data-wow-delay="300ms">La <span>Carte</span> </h1>
                    <div class="pricing-list">


                        <c:forEach items="${cat}" var="cate">
                            <div class="title">
                                <h3><span>${cate.nom}</span></h3>
                            </div>
                            <c:forEach items="${cate.sousCategories}" var="ssCate">


                                <div class="title">
                                    <h4>${ssCate.nom} </h4>
                                </div>
                                <ul>
                                     <c:forEach items="${ssCate.articles}" var="article">
                                    <li class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="300ms">
                                        <div class="item">
                                            <div class="item-title">
                                                <h2>${article.nom}</h2>
                                                <div class="border-bottom"></div>
                                                <span>${article.prixTtc}</span>
                                            </div>
                                            <p>${article.description}</p>
                                        </div>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </c:forEach>
                            </c:forEach>




                            
                            <a class="btn btn-default pull-right wow bounceIn" data-wow-duration="500ms" data-wow-delay="1200ms" href="#" role="button">More Info</a>
                    </div>
                </div>
            </div><!-- .col-md-12 close -->
        </div><!-- .row close -->
    </div><!-- .containe close -->
</section><!-- #price close -->
