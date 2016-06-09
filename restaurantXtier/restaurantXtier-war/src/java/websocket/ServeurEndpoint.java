package websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/serveurendpoint", decoders = {CommandeDecoder.class}, encoders = {CommandeEncoder.class})
public class ServeurEndpoint {
    
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    private static HashMap<Session, Integer> commandesMap = new HashMap<>();
    private static HashMap<Session, Integer> rolesMap = new HashMap<>();
    
    @OnMessage
    public void onMessage(WsCommandeAction action, Session session) throws IOException, EncodeException {
        
        System.out.println("ON MESSAGE ENDPOINT");
        
        Integer roleUser = action.getRoleUser();
        Integer cleCommande = action.getCleCommande();
        
        
        if ("log".equalsIgnoreCase(action.getAction())) {
            commandesMap.put(session, cleCommande);
            rolesMap.put(session, roleUser);
            System.out.println("LOG GOOD");
        }
        
        if ("help".equalsIgnoreCase(action.getAction())) {
            System.out.println("DANS LE HELP ENDPOINT");
            Iterator iter = commandesMap.entrySet().iterator();
            while (iter.hasNext()) {
                
                Map.Entry<Session, Integer> entry = (Map.Entry) iter.next();
                if (!entry.getKey().equals(session) && entry.getValue().equals(cleCommande)) {
                    System.out.println("AVANT TEST ROLE DANS ENDPOINT");
                    Iterator ite2 = rolesMap.entrySet().iterator();
                    while (ite2.hasNext()) {
                        Map.Entry<Session, Integer> entry2 = (Map.Entry) iter.next();
                        if (entry2.getKey().equals(roleUser)) {
                            Session peer = entry2.getKey();
                            peer.getBasicRemote().sendObject(action);
                        }
                    }
                }
            }
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
