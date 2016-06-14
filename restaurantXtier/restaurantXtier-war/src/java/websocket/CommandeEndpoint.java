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

@ServerEndpoint(value = "/commandeendpoint", decoders = {CommandeDecoder.class}, encoders = {CommandeEncoder.class})
public class CommandeEndpoint {

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    private static HashMap<Session, Integer> commandesMap = new HashMap<>();

    @OnMessage
    public void onMessage(WsCommandeAction action, Session session) throws IOException, EncodeException {

        if ("log".equalsIgnoreCase(action.getAction())) {
            System.out.println("LOG COMMANDE CLIENT");
            Integer cleCommande = action.getCleCommande();
            commandesMap.put(session, cleCommande);

            Iterator iter = commandesMap.entrySet().iterator();

            System.out.println("Hashmap du endpoint ");
            while (iter.hasNext()) {
                Map.Entry<Integer, Session> entry = (Map.Entry) iter.next();
                System.out.println("key = " + entry.getKey() + " and value = " + entry.getValue());
            }
        }

        if (!"log".equalsIgnoreCase(action.getAction())) {
            System.out.println("ACTION REFRESH DEMANDE DE LA COMMANDE DANS ENDPOINT");
            Integer cleCommande = action.getCleCommande();
            Iterator iter = commandesMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Session, Integer> entry = (Map.Entry) iter.next();
                if (!entry.getKey().equals(session) && entry.getValue().equals(cleCommande)) {
                    Session peer = entry.getKey();
                    peer.getBasicRemote().sendObject(action);
                }
            }
        }
        
        
        
    }

    @OnOpen
    public void onOpen(Session peer) {
        System.out.println("<<<<<<<<OPEN COMMANDE>>>>>>>>");
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {

        commandesMap.remove(peer);
        System.out.println(commandesMap.size());

        peers.remove(peer);
    }

    @OnError
    public void onError(Throwable t) {
    }

}
