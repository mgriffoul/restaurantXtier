<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <c:forEach items="${listEmplacement}" var="element">
            <a href='javascript: toggle()'>toggle</a>

            <figure>
                <a href="index?table=${element.numero}&section=IHMSalle">
                    <img src="images/IHM_salle/table_empty.png" alt=".." />
                </a>
                <figcaption><p>${element.statut}</p><p>Numéro : ${element.numero}</p></figcaption>
            </figure>
        </div>
    </c:forEach>
</div>