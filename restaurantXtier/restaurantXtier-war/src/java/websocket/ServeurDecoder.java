
package websocket;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ServeurDecoder implements Decoder.Text<WsCommandeAction>{
    
      public ServeurDecoder() {
    }

    @Override
    public WsCommandeAction decode(String s) throws DecodeException {
        JsonObject jsonObject = Json.createReader(new StringReader(s)).readObject();
        
        String password = jsonObject.getString("password");
        String action = jsonObject.getString("action");
        Integer cleCommande = Integer.valueOf(jsonObject.getString("cleCommande"));
        WsCommandeAction wca = new WsCommandeAction(cleCommande, password, action);
        return wca;
    }

    @Override
    public boolean willDecode(String s) {
        try {
            Json.createReader(new StringReader(s)).readObject();
            return true;
        } catch (JsonException ex) {
            ex.printStackTrace();
            return false;
        }
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
