//var wsUri = "ws://" + document.location.host + document.location.pathname + "commandeendpoint";
var path = document.location.pathname;
var path2 = path.replace("/index", "");
var wsUri = "ws://" + document.location.host + path2 + "/commandeendpoint";


var websocketcom = new WebSocket(wsUri);

websocketcom.onerror = function () {
    onError();
};

function onError() {
    alert("erreur");
}

websocketcom.onmessage = function (evt) {
    onMessage(evt);
};



function sendOrder(cleCommande, action) {

    if (action === null || action === undefined) {
        action = "refresh";
    }
    var json = JSON.stringify({
        "password": "4444",
        "action": action,
        "cleCommande": cleCommande

    });
    waitForSocketConnection(websocket, function () {
        websocketcom.send(json);
    });
}




function waitForSocketConnection(socket, callback) {
    setTimeout(
            function () {
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



function onMessage(evt) {
    
    var json = JSON.parse(evt.data);


    action = json.action;
    cleCommande=json.cleCommande;
    
    if (action === "close") {
        closeCommande(cleCommande);
    } else {
        
        refreshHeader();
        refreshMesCommandes();
    }
}

function closeCommande(cleCommande){
    bootbox.alert("un convive a cloturer votre commande, un serveur arrive pour la valider. Vous pourrez lui demander d'apporter d'y apporter des modifications à ce moment.", 
    function(){location.assign("index?section=logincomclient&com="+cleCommande);});
    
}


function wslog(cleCommande) {
    var json = JSON.stringify({
        "password": "4444",
        "action": "log",
        "cleCommande": cleCommande
    });
    waitForSocketConnection(websocketcom, function () {
        websocketcom.send(json);
    });


}


