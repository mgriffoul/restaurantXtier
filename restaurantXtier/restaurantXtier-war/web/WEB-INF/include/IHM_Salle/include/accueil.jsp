<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="gallery">
    <div class="spacer">
        &nbsp;
    </div>
    <form method="POST"  action="index">
        <input type="hidden" name="section" value="IHMSalle">
        <input type="hidden" name="inc" value="createOrder">
        <c:forEach items="${listEmplacement}" var="emp">
            <div class="row">  
                <c:if test="${emp.getStatut() == 'occupe'}">
                    <label id="table_${emp.numero}"><img src="images/IHM_salle/table_occuped.png" alt=".." onclick="free(${emp.numero});" /></label><input type="checkbox" id ="chk_${emp.numero}" name="table" value="${emp.numero}" class="chktable" checked="true">
                    </c:if>
                    <c:if test="${emp.getStatut() == 'libre'}">
                    <label id="table_${emp.numero}"><img src="images/IHM_salle/table_empty.png" alt=".." onclick="occuped(${emp.numero});" /></label><input type="checkbox" id ="chk_${emp.numero}" name="table" value="${emp.numero}" class="chktable">
                    </c:if>
                <p>Table N°: ${emp.numero}</p>
            </div>
        </c:forEach>
        <input type="checkbox" value="YES">
        <input type="submit" value="ok" >

    </form>
    <div class="spacer">
        &nbsp;
    </div>
</div> 
<script  type="text/javascript">
    function occuped(x) {
        document.getElementById('table_' + x + '').innerHTML = '<img src="images/IHM_salle/table_occuped.png" onclick="free(' + x + ');"/>';
        document.getElementById('chk_' + x + '').checked = true;
    }
</script> 
<script  type="text/javascript">
    function free(x) {
        document.getElementById('table_' + x + '').innerHTML = '<img src="images/IHM_salle/table_empty.png" onclick="occuped(' + x + ');"/>';
    }
    document.getElementById('chk_' + x + '').checked = false;
</script> 