
package websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/serveurendpoint", decoders = {CommandeDecoder.class}, encoders = {CommandeEncoder.class})
public class serveurEndpoint {
    
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    private static HashMap<Session, Integer> commandesMap = new HashMap<>();
    private static HashMap<Session, Integer> rolesMap = new HashMap<>();
    
    @OnMessage
    public void onMessage(WsCommandeAction action, Session session) throws IOException, EncodeException {

        if ("log".equalsIgnoreCase(action.getAction())) {
            Integer roleUser = action.getRoleUser();
            Integer cleCommande = action.getCleCommande();
            commandesMap.put(session, cleCommande);
            rolesMap.put(session, roleUser);
            System.out.println("LOG GOOD");
        }

        if ("refresh".equalsIgnoreCase(action.getAction())) {
        }
    }

    @OnOpen
    public void onOpen(Session peer) {
        System.out.println("<<<<<<<<OPEN>>>>>>>>");
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        commandesMap.remove(peer);
        rolesMap.remove(peer);
        peers.remove(peer);
    }

    @OnError
    public void onError(Throwable t) {
    }
}
