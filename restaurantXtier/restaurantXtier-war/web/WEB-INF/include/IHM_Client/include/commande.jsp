<%-- 
    Document   : commande
    Created on : 25 mai 2016, 15:09:26
    Author     : cdi207
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <section id="price">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block ">

                    <h1 class="heading wow fadeInUp carte-titre" data-wow-duration="300ms" data-wow-delay="300ms">votre<span>Commande</span> </h1>
                    <div class="pricing-list ">


                        
                            <div class="title categorie-carte">
                                <h3><span>Entrées</span></h3>
                            </div>
                            <c:forEach items="${entrees}" var="entree">
                                
                                    <ul>
                                          
                                            <li class="wow fadeInUp  article" data-wow-duration="300ms" data-wow-delay="300ms">
                                                <div class="item ">
                                                    <div class="item-title ">
                                                        <h2>${entree.article.nom}</h2>
                                                        <div class="border-bottom"></div>
                                                        <span>${entree.prixHT} E</span>
                                                    </div>
                                                    <p>${entree.article.description}</p>
                                                </div>
                                                <button class="btn btn-success" ><span class="glyphicon  glyphicon-shopping-cart"></span> Retirer</button>
                                                        
                                            </li>
                                        
                                    </ul>
                                
                            </c:forEach>
                       




                     </div>
                </div>
            </div><!-- .col-md-12 close -->
        </div><!-- .row close -->
    </div><!-- .containe close -->
</section><!-- #price close -->