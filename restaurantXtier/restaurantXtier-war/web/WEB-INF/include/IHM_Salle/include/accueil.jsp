<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="gallery">
    <form method="POST"  action="index">
        <input type="hidden" name="section" value="IHMSalle">
        <input type="hidden" name="inc" value="createOrder">
        <c:if test="${OrderValide == 'ok'}">
            <script type="text/javascript"> bootbox.alert("Commande créée!");</script>
        </c:if>
        <c:forEach items="${listEmplacement}" var="emp">
            <div class="row">  
                <c:if test="${emp.getStatut() == 'occupe'}">
                    <label id="table_${emp.numero}"><img src="salle_template/images/IHM_salle/table_occuped.png" alt=".." onclick="location.href = 'index?section=IHMSalle&inc=showOrder&table=${emp.keyCommande}';" /></label>
                    <p>Table N°: ${emp.numero}</p>
                    <p>En cours</p>
                </c:if>
                <c:if test="${emp.getStatut() == 'libre'}">
                    <label id="table_${emp.numero}"><img src="salle_template/images/IHM_salle/table_empty.png" alt=".." onclick="occuped(${emp.numero});" /></label><input type="checkbox" id ="chk_${emp.numero}" name="table" value="${emp.numero}" class="chktable">
                    <p>Table N°: ${emp.numero}</p>
                    <p>Libre</p>
                </c:if>
                <c:if test="${emp.getStatut() == 'help'}">
                    <label id="table_${emp.numero}"><img src="salle_template/images/IHM_salle/table_alert.png" alt=".." onclick="location.href = 'index?section=IHMSalle&inc=showOrder&table=${emp.keyCommande}';" /></label>
                    <p>Table N°: ${emp.numero}</p>
                    <p>Besoin d'aide</p>
                </c:if>
                <c:if test="${emp.getStatut() == 'non valide'}">
                    <label id="table_${emp.numero}"><img src="salle_template/images/IHM_salle/table_selected.png" alt=".." onclick="location.href = 'index?section=IHMSalle&inc=showOrder&table=${emp.keyCommande}';" /></label>
                    <p>Table N°: ${emp.numero}</p>
                    <p>Non validée</p>
                </c:if> 
                <c:if test="${emp.getStatut() == 'valide'}">
                    <label id="table_${emp.numero}"><img src="salle_template/images/IHM_salle/client_valid.png" alt=".." onclick="location.href = 'index?section=IHMSalle&inc=showOrder&table=${emp.keyCommande}';" /></label>
                    <p>Table N°: ${emp.numero}</p>
                    <p>Non validée</p>
                </c:if> 
            </div>
        </c:forEach>
        <input type="submit" value="Créer commande" >
    </form>
</div> 



