
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<section id="price">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block ">

                    <h1 class="heading wow fadeInUp carte-titre" data-wow-duration="300ms" data-wow-delay="300ms"> <span>${for.nom}</span> </h1>
                    <div class="pricing-list ">
                        <ul>

                            <li class="wow fadeInUp  formule" data-wow-duration="300ms" data-wow-delay="300ms">
                                <div class="item form">
                                    <div class="item-title ">
                                        <h2>${for.nom}</h2>
                                        <div class="border-bottom"></div>
                                        
                                    </div>
                                    
                                    <form method="POST" action="index">
                                        
                                        
                                        <input type="hidden" name="section" value="ihmclient">
                                        <input type="hidden" name="inc" value="validForm">
                                        <input type="hidden" name="idForm" value="${for.id}">
                                        
                                        <c:if test="${not empty for.entrees}">
                                            <p> 
                                                <label for="entree"> Entrée au choix</label></p>

                                            <select class="form-control liste-formule" name="entree">
                                                 <option value="0" selected></option>
                                                <c:forEach items="${for.entrees}" var="entree">
                                                    <option value="${entree.id}">${entree.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </c:if>

                                        <c:if test="${not empty for.plats}">
                                            <p> <label for="plat">Plat au choix</label></p>

                                            <select class="form-control liste-formule" name="plat">
                                                 <option value="0" selected></option>
                                                <c:forEach items="${for.plats}" var="plat">
                                                    <option value="${plat.id}">${plat.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </c:if>

                                        <c:if test="${not empty for.desserts}">
                                            <p><label for="dessert"> Dessert au choix</label></p>

                                            <select class="form-control liste-formule" name="dessert">
                                                <option value="0" selected></option>
                                                <c:forEach items="${for.desserts}" var="dessert">
                                                    <option value="${dessert.id}">${dessert.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </c:if>

                                        <c:if test="${not empty for.boissons}">
                                            <p> <label for="dessert">Boisson au choix</label></p>

                                            <select class="form-control liste-formule" name="boisson">
                                                 <option value="0" selected></option>
                                                <c:forEach items="${for.boissons}" var="boisson">
                                                    <option value="${boisson.id}">${boisson.nom}</option>
                                                </c:forEach>
                                            </select>
                                        </c:if>

                                </div>
                                
                                        <p>  <button class="btn btn-success btn-valider" type="submit" value="valid"><span ></span> Valider</button>
                                        </p>
                                </form>
                                    
                                        <p> ${message}</p>
                            </li>

                        </ul>
                    </div>
                </div>
            </div><!-- .col-md-12 close -->
        </div><!-- .row close -->
    </div><!-- .containe close -->
</section><!-- #price close -->
