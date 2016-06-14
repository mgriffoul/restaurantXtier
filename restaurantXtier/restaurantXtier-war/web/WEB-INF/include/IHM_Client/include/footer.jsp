
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>

 <!--
        footer-bottom  start
        ============================= -->
        <footer id="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="block">
                            <nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
                            <p>Copyright &copy; 2014 - All Rights Reserved.Design and Developed By <a href="http://www.themefisher.com">Themefisher</a>
                                <c:if test="${not empty deco}"> 
                                <a class="btn btn-danger btn-group-sm boutondeco" href="#" onclick="demandeKill();" role="button"><span class="glyphicon glyphicon-off"></span></a>
                                </c:if>
                            </p>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
