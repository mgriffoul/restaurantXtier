<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:url value="/createBdd" var="url01" />
    <a href="${url01}">Créer base de donnée</a>  
    <br/>
    <c:url value="/testbean" var="url02" />
    <a href="${url02}">Tester les beans</a>  
<hr />
</div>   
