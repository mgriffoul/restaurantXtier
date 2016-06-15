
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
   
    var xhr = getXmlHttpRequest();
    xhr.onreadystatechange = function (){

        if(xhr.readyState == 4 && xhr.status == 200){

            var maDiv = document.getElementById("Affichage");
            var reponse = xhr.responseText;
            //alert(reponse);
            maDiv.innerHTML = reponse;
        }
    };
    xhr.open("GET", url, true);
    xhr.send(null);
    setInterval('actualiserDiv(ssSec)', 5000);
}
function afficherHeure() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('heure').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(afficherHeure, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}












