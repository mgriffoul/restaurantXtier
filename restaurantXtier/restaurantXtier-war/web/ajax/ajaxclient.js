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


function refreshHeader(){
    var url = "index?section=clientRefresh&refresh=header";
    
    var xhr = getXmlHttpRequest(); 
    
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4 && xhr.status == 200){
            var maDiv = document.getElementById("header");
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };
    
    xhr.open("GET", url, true);
    xhr.send(null);
    
}



function addArticle(idDom, idArticle){
   alert(idDom+" "+idArticle);
   
    var url = "index?section=actionCom&act=add&id="+idArticle;
    
    var xhr = getXmlHttpRequest();
    
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4 && xhr.status == 200){
            var maDiv = document.getElementById(idDom);
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };
    xhr.open("GET", url, true);
    xhr.send(null);
}
