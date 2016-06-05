
package websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/commandeendpoint", decoders = {CommandeDecoder.class},encoders = {CommandeEncoder.class})
public class CommandeEndpoint {

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    
    @OnMessage
    public void onMessage(WsCommandeAction action, Session session) {
        System.out.println(":::::::::::::Message reçu::::::::::::::");
        
    }

    @OnOpen
    public void onOpen(Session peer) {
        System.out.println("<<<<<<<<OPEN>>>>>>>>");
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        System.out.println(">>>>>>CLOSE<<<<<<<<");
        peers.remove(peer);
        
    }

    @OnError
    public void onError(Throwable t) {
    }
    
    
    
    
    
}
