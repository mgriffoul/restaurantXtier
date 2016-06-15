<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${commande.getStatut() == 'en cours'}">
        <p> Commande N° ${commande.getNumero()} créée avec succès et envoyée en cuisine! </p>
     </c:if>
         <c:if test="${commande.getStatut() != 'en cours'}">
         <form method="POST"  action="index">
        <input type="hidden" name="section" value="IHMSalle">
        <input type="hidden" name="inc" value="validOrder">
        <input type="hidden" name="table" value="${table}">
        <input type="submit" value="Valider cette commande" >
    </form>
     </c:if>
  
