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

function sendText() {
    
    var json = JSON.stringify({
        "idArticle": 12,
        "action": "ajouter",
        "numCommande": "com0001254"
    });
    
    alert("sending text: " + json);
    websocket.send(json);
}
                
function onMessage() {
    alert("received: ");
}
