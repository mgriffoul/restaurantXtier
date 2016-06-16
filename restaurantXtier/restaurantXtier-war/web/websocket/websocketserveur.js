
//var wsUri = "ws://" + document.location.host + document.location.pathname + "commandeendpoint";
var path = document.location.pathname;
var path2 = path.replace("/index", "");
var wsUri = "ws://" + document.location.host + path2 + "/serveurendpoint";


var websocket = new WebSocket(wsUri);

websocket.onerror = function () {
    onError();
};

function onError() {
    alert("erreur");
}



function sendHelpServeur(cleCommande, codeServeur) {
    var json = JSON.stringify({
        "password": codeServeur,
        "action": "help",
        "cleCommande": cleCommande

    });
    waitForSocketConnection(websocket, function () {
        websocket.send(json);
    });
    bootbox.alert("Un serveur a été appelé");
}

function sendValidServeur(cleCommande, codeServeur) {
    var json = JSON.stringify({
        "password": codeServeur,
        "action": "valid",
        "cleCommande": cleCommande
        
    });
    waitForSocketConnection(websocket, function() {
           websocket.send(json);
        });
        bootbox.alert("Un serveur va venir valider votre commande.");
}


function waitForSocketConnection(socket, callback){
        setTimeout(
            function(){
                if (socket.readyState === 1) {
                    if (callback !== undefined) {
                        callback();
                    }
                    return;
                } else {
                    waitForSocketConnection(socket, callback);
                }
            }, 5);
}
;

websocket.onmessage = function (evt) {
    onMessage(evt);
};

function onMessage(evt) {
    var json = JSON.parse(evt.data);
    action = json.action;
    alert(action);
    cleCommande = json.cleCommande;
    if (action === "help") {
        refreshTable(cleCommande);
    }
    if (action === "valid") {
        validCommande(cleCommande);
    }
}

function refreshTable(cleCommande) {
    bootbox.alert("De(s) client(s) ont besoins d'aide!",
            function () {
                location.assign("index?section=IHMSalle&inc=helpTable&com=" + cleCommande);
            });
}
function validCommande(cleCommande) {
    bootbox.alert("De(s) client(s) ont validé(s) une commande!",
            function () {
                location.assign("index?section=IHMSalle&inc=orderTable&com=" + cleCommande);
            });
}

function wslogServ(password) {

    var json = JSON.stringify({
        "password": password,
        "action": "log",
        "cleCommande": "0"
    });

    waitForSocketConnection(websocket, function () {
        websocket.send(json);
    });
}

 






