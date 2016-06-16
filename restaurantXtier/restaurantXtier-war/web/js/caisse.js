setInterval(
        function(){
            recharger(),10000;
        }
        );



function getXmlHttpRequest() {
    var xhr = null;
    if (window.XMLHttpRequest) // Firefox et autres
        xhr = new XMLHttpRequest();
    else if (window.ActiveXObject) { // Internet Explorer
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    else { // XMLHttpRequest non supporté par le navigateur
        alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest...");
        xhr = false;
    }
    return xhr;
}

function afficherCommande(num){
    var url = "index?section=IHMCaisse&incCaisse=ticket&nCom="+num;
    // alert(url);
    var xhr = getXmlHttpRequest();
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4 && xhr.status == 200){
            var maDiv = document.getElementById("ticket");
            var reponse = xhr.responseText;
            //alert(reponse);
            maDiv.innerHTML = reponse;
        }
    };

    var phrase = "<a href='#' onclick=\"payer('"+num+"');\">CB</a>";
    var ph2 = "<a href='#' onclick=\"payer('"+num+"');\">Espece</a>";
    var ph3 = "<a href='#' onclick=\"payer('"+num+"');\">TR</a>";

    document.getElementById("payer").innerHTML = phrase;
    document.getElementById("payerE").innerHTML = ph2;
    document.getElementById("payerTR").innerHTML = ph3;
    xhr.open("GET", url, true);
    xhr.send(null);
}

function afficheur() {
        
        alert("nom zone"+texte);
        return texte ;
    }

function ajouter(touche) {
   var texte = document.getElementById("afficheur");
   texte.value += touche ;
 }

function vider(){
    var texte = document.getElementById("afficheur");
    texte.value = "";
}

function payer(num){
    
    var url = "index?section=IHMCaisse&incCaisse=payer&nCom="+num;
    
    var xhr = getXmlHttpRequest();
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4 && xhr.status == 200){
            var maDiv = document.getElementById("afficherCommande");
            var reponse = xhr.responseText;
            
            maDiv.innerHTML = reponse;
        }
    };
    vider();
    xhr.open("GET", url, true);
    xhr.send(null);   
}

function recharger(){
    var url = "index?section=IHMCaisse&incCaisse=recharger";
    
    var xhr = getXmlHttpRequest();
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4 && xhr.status == 200){
            var maDiv = document.getElementById("afficherCommande");
            var reponse = xhr.responseText;
            
            maDiv.innerHTML = reponse;
        }
    };
    xhr.open("GET", url, true);
    xhr.send(null);   
}