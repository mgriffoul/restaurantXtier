//var wsUri = "ws://" + document.location.host + document.location.pathname + "commandeendpoint";
var path = document.location.pathname;
var path2 = path.replace("/index", "");
var wsUri = "ws://" + document.location.host + path2 + "/commandeendpoint";


var websocketcom = new WebSocket(wsUri);

websocketcom.onerror = function() { 
    onError(); 
};

function onError() {
    alert("erreur");
}

websocketcom.onmessage = function() { onMessage(); };

function sendOrder(cleCommande) {
    alert("sendORDER");
    var json = JSON.stringify({
        "password": "4444",
        "action": "refresh",
        "cleCommande": cleCommande
        
    });
    waitForSocketConnection(websocket, function() {
           websocketcom.send(json);
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
    alert("ONMESSAGE");
    refreshHeader();
    refreshMesCommandes();
}


function wslog(cleCommande){
    alert("wslog");
    var json = JSON.stringify({
        "password": "4444",
        "action": "log",
        "cleCommande": cleCommande
    });
     waitForSocketConnection(websocketcom, function() {
           websocketcom.send(json);
        });
    
    
}
function test(){
    alert("test");
}


