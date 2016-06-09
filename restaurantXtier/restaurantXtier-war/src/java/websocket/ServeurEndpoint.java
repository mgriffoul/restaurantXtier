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
    private static HashMap<Session, String> passwords = new HashMap<>();
    
    @OnMessage
    public void onMessage(WsCommandeAction action, Session session) throws IOException, EncodeException {
        
        System.out.println("ON MESSAGE ENDPOINT");
        
        String password = action.getPassword();
        
        
        if ("log".equalsIgnoreCase(action.getAction())) {
            
            passwords.put(session, password);
            
            System.out.println("LOG GOOD");
        }
        
        if ("help".equalsIgnoreCase(action.getAction())) {
            
                    System.out.println("AVANT TEST ROLE DANS ENDPOINT");
                    Iterator iter = passwords.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry<Session, String> entry2 = (Map.Entry) iter.next();
                        if(password.equalsIgnoreCase(entry2.getValue())){
                            System.out.println("TEST CODE DANS ENDPOINT");
                           Session peer = entry2.getKey();
                            peer.getBasicRemote().sendObject(action);
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
        passwords.remove(peer);
        peers.remove(peer);
    }
    
    @OnError
    public void onError(Throwable t) {
    }
}
