
//var wsUri = "ws://" + document.location.host + document.location.pathname + "commandeendpoint";
var path = document.location.pathname;
var path2 = path.replace("/index", "");
var wsUri = "ws://" + document.location.host + path2 + "/serveurendpoint";


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
    waitForSocketConnection(websocket, function() {
           websocket.send(json);
        });
}




function waitForSocketConnection(socket, callback){
        setTimeout(
            function(){
                if (socket.readyState === 1) {
                    if(callback !== undefined){
                        callback();
                    }
                    return;
                } else {
                    waitForSocketConnection(socket,callback);
                }
            }, 5);
    };



function onMessage() {
    refreshHeader();
    refreshMesCommandes();
}


function wslogServ(cleCommande, intRole){
    
    var json = JSON.stringify({
        "cleCommande": cleCommande,
        "action": "log",
        "roleUser": intRole
    });
     waitForSocketConnection(websocket, function() {
           websocket.send(json);
        });
    
    
}
function test(){
    alert("test");
}



