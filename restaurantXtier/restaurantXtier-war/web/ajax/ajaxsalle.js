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

function occuped(x) {
    document.getElementById('table_' + x + '').innerHTML = '<img src="salle_template/images/IHM_salle/table_selected.png" onclick="free(' + x + ');"/>';
    document.getElementById('chk_' + x + '').checked = true;
}


function free(x) {
    document.getElementById('table_' + x + '').innerHTML = '<img src="salle_template/images/IHM_salle/table_empty.png" onclick="occuped(' + x + ');"/>';
    document.getElementById('chk_' + x + '').checked = false;
}




function refreshHeader() {
    var url = "index?section=IHMSalle&refresh=emplacement";

    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var maDiv = document.getElementById("header");
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };

    xhr.open("GET", url, true);
    xhr.send(null);

}

function refreshMesCommandes() {

    var url = "index?section=clientRefresh&refresh=commande";

    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {

            var maDiv = document.getElementById("commandes");
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };

    xhr.open("GET", url, true);
    xhr.send(null);
}


function addArticle(idDom, idArticle) {

    var url = "index?section=actionCom&act=add&id=" + idArticle;

    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var maDiv = document.getElementById(idDom);
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };
    xhr.open("GET", url, true);
    xhr.send(null);
}
function suppArticle(idDom, idArticle) {

    var url = "index?section=actionCom&act=supp&id=" + idArticle + "&dom=" + idDom;

    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var maDiv = document.getElementById(idDom);
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };
    xhr.open("GET", url, true);
    xhr.send(null);
}
function suppFormule(idDom, refFormule) {

    var url = "index?section=actionCom&act=suppFor&id=" + refFormule + "&dom=" + idDom;

    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var maDiv = document.getElementById(idDom);
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };
    xhr.open("GET", url, true);
    xhr.send(null);
}

