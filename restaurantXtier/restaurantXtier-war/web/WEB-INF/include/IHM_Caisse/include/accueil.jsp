
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>INTERFACE CAISSE</h1>


<h1>${titre}</h1>
<div class="divprincipale">
    <div class="encadre">
        <div class="partiegauche">           
            <div id="afficherCommande">
                <c:import url="WEB-INF/include/IHM_Caisse/include/commandes.jsp" />
            </div>


            <div>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <form id="afficeurPrix">
                                    <input type="text" value="" name="afficheur" class="afficheur" id="afficheur" readonly="readonly" /><br />
                                </form> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table border="1" class="boutoncaisse">
                                    <tbody>                  
                                        <tr>
                                            <td><a href="#" onclick="ajouter('7');
                                                return false;">7</a></td>
                                            <td><a href="#" onclick="ajouter('8');
                                                return false;">8</a></td>
                                            <td><a href="#" onclick="ajouter('9');
                                                return false;">9</a></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#" onclick="ajouter('4');
                                                return false;">4</a></td>
                                            <td><a href="#" onclick="ajouter('5');
                                                return false;">5</a></td>
                                            <td><a href="#" onclick="ajouter('6');
                                                return false;">6</a></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#" onclick="ajouter('1');
                                                return false;">1</a></td>
                                            <td><a href="#" onclick="ajouter('2');
                                                return false;">2</a></td>
                                            <td><a href="#" onclick="ajouter('3');
                                                return false;">3</a></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#" onclick="vider();
                                                return false;">C</a></td>
                                            <td><a href="#" onclick="ajouter('0');
                                                return false;">0</a></td>
                                            <td><a href="#" onclick="ajouter('.');
                                                return false;">.</a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>


                            <td>

                                <table border="2" class="btn-droite">
                                    <tr>
                                        <td id="payer">
                                            <a href="#" onclick="payer('${payercommande}');">CB</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="payerE">
                                            <a href="#" onclick="payer('${payercommande}');">Espece</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="payerTR">
                                            <a href="#" onclick="payer('${payercommande}');">TR</a>
                                        </td>
                                    </tr>
                                </table>

                            </td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
        <div id="partiedroite">
            <p>
            <a href="#" onclick="recharger()" class="btn">Actualiser</a>
            <a href="#" class="btn">Imprimer</a>   
            </p>
        <div id="ticket">
            <c:import url="WEB-INF/include/IHM_Caisse/include/ticket.jsp" />
        </div>
        </div>
    </div> 
</div>


<script src="js/caisse.js"></script>
<script type="text/javascript">window.setInterval("actualiser()",600000);</script>
