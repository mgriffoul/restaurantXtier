<%-- 
    Document   : formules
    Created on : 25 mai 2016, 15:06:31
    Author     : cdi207
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="price">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block ">

                    <h1 class="heading wow fadeInUp carte-titre" data-wow-duration="300ms" data-wow-delay="300ms">Les <span>Formules</span> </h1>
                    <div class="pricing-list ">


                     

                                <div class="title souscategorie-carte">
                                    <h4>${ssCate.nom} </h4>
                                </div>
                                
                                    <ul>
                                        <c:forEach items="${for}" var="form">
                                            
                                            <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                                <div class="item ">
                                                    <div class="item-title ">
                                                        <h2>Formule ${form.nom}</h2>
                                                        <div class="border-bottom"></div>
                                                        <span>${form.prixTtc} E</span>
                                                    </div>
                                                    <p>
                                                        <c:forEach items="${form.articles}" var="article">
                                                            ${article.nom},
                                                        </c:forEach>
                                                    </p>
                                                </div>
                                                <button class="btn btn-success"><span class="glyphicon  glyphicon-shopping-cart"></span> Commander</button>
                                                        
                                            </li>
                                        </c:forEach>
                                    </ul>
                           





                        <a class="btn btn-default pull-right wow bounceIn" data-wow-duration="500ms" data-wow-delay="1200ms" href="#" role="button">More Info</a>
                    </div>
                </div>
            </div><!-- .col-md-12 close -->
        </div><!-- .row close -->
    </div><!-- .containe close -->
</section><!-- #price close -->

