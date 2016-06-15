
package websocket;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class ServeurEncoder implements Encoder.Text<WsCommandeAction>{
    
     @Override
    public String encode(WsCommandeAction wca) throws EncodeException {
        
        String s = Json.createObjectBuilder()
                        .add("password", wca.getPassword())
                        .add("action", wca.getAction())
                        .add("cleCommande", wca.getCleCommande())
                        
                   .build().toString();
        
        return s;
    }

    @Override
    public void init(EndpointConfig ec) {
        System.out.println("init SERVEUR");
    }

    @Override
    public void destroy() {
        System.out.println("destroy SERVEUR");
    }
    
}
