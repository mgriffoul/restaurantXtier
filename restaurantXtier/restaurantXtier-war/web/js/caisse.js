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
    var url = "index?section=IHMCaisse?inc=ticket&nCom="+num;
    // alert(url);
    var xhr = getXmlHttpRequest();
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4 && xhr.status == 200){
            var maDiv = document.getElementById("ticket");
            var reponse = xhr.responseText;
            // alert(reponse);
            maDiv.innerHTML = reponse;
        }
    };
   
    xhr.open("GET", url, true);
    xhr.send(null);
}
