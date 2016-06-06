
package websocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
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
    private static HashMap<Integer, Session> commandesMap = new HashMap<>();
    
    
    @OnMessage
    public void onMessage(WsCommandeAction action, Session session) {
        
        if("log".equalsIgnoreCase(action.getAction())){
            Integer cleCommande = action.getCleCommande();
            commandesMap.put(cleCommande, session);
            
            Iterator iter = commandesMap.entrySet().iterator();
            
            System.out.println("Hashmap du endpoint ");
            while(iter.hasNext()){
                Map.Entry<Integer, Session> entry =(Map.Entry) iter.next();
                System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue());
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
       
        Iterator iter = commandesMap.entrySet().iterator();
            
            while(iter.hasNext()){
                Map.Entry<Integer, Session> entry =(Map.Entry) iter.next();
                if (entry.getValue().equals(peer)){
                    commandesMap.remove(entry.getKey());
                }
            }
        System.out.println(commandesMap.size());
            
        peers.remove(peer);
    }

    @OnError
    public void onError(Throwable t) {
    }
    
    
    
    
    
}
