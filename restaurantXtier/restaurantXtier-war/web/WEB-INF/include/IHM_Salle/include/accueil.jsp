<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="gallery">
    <form method="POST"  action="index">
        <input type="hidden" name="section" value="IHMSalle">
        <input type="hidden" name="inc" value="createOrder">
        <c:forEach items="${listEmplacement}" var="emp">
            <div class="row">  
                <c:if test="${emp.getStatut() == 'occupe'}">
                    <label id="table_${emp.numero}"><img src="salle_template/images/IHM_salle/table_occuped.png" alt=".." onclick="location.href = 'index?section=IHMSalle&inc=showOrder&table=${emp.numero}';" /></label>
                    <p>Table N°: ${emp.numero}</p>
                    <p><b>Commande N°: ${emp.commandeEnCour.getNumero()}</b></p>
                </c:if>
                <c:if test="${emp.getStatut() == 'libre'}">
                    <label id="table_${emp.numero}"><img src="salle_template/images/IHM_salle/table_empty.png" alt=".." onclick="occuped(${emp.numero});" /></label><input type="checkbox" id ="chk_${emp.numero}" name="table" value="${emp.numero}" class="chktable">
                    <p>Table N°: ${emp.numero}</p>
                </c:if>
            </div>
        </c:forEach>
        <input type="submit" value="ok" >
    </form>
</div> 
<script  type="text/javascript">
    function occuped(x) {
        document.getElementById('table_' + x + '').innerHTML = '<img src="salle_template/images/IHM_salle/table_selected.png" onclick="free(' + x + ');"/>';
        document.getElementById('chk_' + x + '').checked = true;
    }
</script> 
<script  type="text/javascript">
    function free(x) {
        document.getElementById('table_' + x + '').innerHTML = '<img src="salle_template/images/IHM_salle/table_empty.png" onclick="occuped(' + x + ');"/>';
        document.getElementById('chk_' + x + '').checked = false;
    }

</script> 