//var wsUri = "ws://" + document.location.host + document.location.pathname + "commandeendpoint";
var path = document.location.pathname;
var path2 = path.replace("/index", "");
var wsUri = "ws://" + document.location.host + path2 + "/commandeendpoint";


var websocket = new WebSocket(wsUri);

websocket.onerror = function() { 
    onError(); 
};

function onError() {
    alert("erreur");
}

websocket.onmessage = function() { onMessage(); };

function sendOrder(cleCommande) {
    var json = JSON.stringify({
        "cleCommande": cleCommande,
        "action": "refresh"
    });
    websocket.send(json);
}


function onMessage() {
    refreshHeader();
    alert("order refresh !");
}


function wslog(cleCommande){
    alert("cle commande" + cleCommande);
    
    var json = JSON.stringify({
        "cleCommande": cleCommande,
        "action": "log"
    });
    websocket.send(json);
}
function test(){
    alert("test");
}

//        this.cleCommande = cleCommande;
//        this.action = action;
//        this.idArticle = idArticle;
//        this.idFormule = idFormule;
//        this.idEntree = idEntree;
//        this.idPlat = idPlat;
//        this.idDessert = idDessert;
//        this.idBoisson = idBoisson;