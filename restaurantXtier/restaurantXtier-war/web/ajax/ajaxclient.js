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


function refreshHeader() {
    alert("refresh header");
    var url = "index?section=clientRefresh&refresh=header";

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
alert("refresh mes commandes");
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

function refreshFormule() {

    var url = "index?section=clientRefresh&refresh=formule";

    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {

            var maDiv = document.getElementById("formule");
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };

    xhr.open("GET", url, true);
    xhr.send(null);
}

function refreshCarte() {

    var url = "index?section=clientRefresh&refresh=carte";

    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {

            var maDiv = document.getElementById("carte");
            var response = xhr.responseText;
            maDiv.innerHTML = response;
        }
    };

    xhr.open("GET", url, true);
    xhr.send(null);
}

function testbootbox(cleCommande, codeServeur) {
    alert("testBootbox, cle = "+cleCommande+" code = "+codeServeur);
    bootbox.confirm("Etes vous certain de vouloir valider la commande ? La commande ne pourra plus être modifié par aucun convive après confirmation.", function (result) {
        if (result === true) {
            alert("result true");
            validerCommande();
            sendOrder(cleCommande, "close");
            sendValidServeur(cleCommande, codeServeur);
        }
    });
}


function validerCommande() {

    var url = "index?section=clientRefresh&refresh=commande&actionRefresh=valid";

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

function demandeKill() {
    
    bootbox.prompt("Entrez votre mot de passe", function (result) {
        killSession(result);
    });
}

function killSession(password) {
    
    var url = "index?section=actionCom&act=kill&pass=" + password;
    var xhr = getXmlHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var response = xhr.responseText;
            
            result = response.toString();


            bootbox.alert(result,
                    function () {
                        location.assign("index?section=ihmclient");
                    });
        }
    };

    xhr.open("POST", url, true);
    xhr.send(null);

}