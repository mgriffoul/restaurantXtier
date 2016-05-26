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
                        

                            <h1>formules</h1>
                            
                            <c:forEach items="${for}" var="ssCate">
                                <div class="block">
                                ${ssCate.nom}
                                <c:forEach items="${ssCate.articles}" var="a">
                                    ${a.nom}  ${a.sousCategorie} ${a.sousCategorie.categorie} 
                                    
                                </c:forEach>
                                </div>
                            </c:forEach>
                        
                    </div><!-- .col-md-12 close -->
                </div><!-- .row close -->
            </div><!-- .containe close -->
        </section><!-- #price close -->