
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

function actualiserDiv(ssSec){
    var url = "index?section=IHMCuisine&inc="+ssSec+"&meth=actu"; //
    
//    alert(url);
    var xhr = getXmlHttpRequest();
    xhr.onreadystatechange = function (){
//        alert("avant le if")
        if(xhr.readyState == 4 && xhr.status == 200){
//            alert("on est dans le if")
            var maDiv = document.getElementById("Affichage");
            var reponse = xhr.responseText;
            //alert(reponse);
            maDiv.innerHTML = reponse;
        }
    };
   
    xhr.open("GET", url, true);
    xhr.send(null);
}









