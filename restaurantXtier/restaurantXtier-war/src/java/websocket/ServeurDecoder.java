
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
        System.out.println("+++++decoding Serveur");
        System.out.println("String entrante Serveur = " + s);
        JsonObject jsonObject = Json.createReader(new StringReader(s)).readObject();
        System.out.println("jsonobject created serveur");

        String password = jsonObject.getString("password");
        System.out.println("PASSWORD DECODER  SERVEUR"+password);
        
        String action = jsonObject.getString("action");
        System.out.println("ACTION SERVEUR= " + action);
        
        Integer cleCommande = Integer.valueOf(jsonObject.getString("cleCommande"));
        System.out.println("CLE COMMANDE DECODER SERVEUR  "+cleCommande);

        WsCommandeAction wca = new WsCommandeAction(cleCommande, password, action);

        System.out.println(">>>>-->>>> WAC SERVEUR = " + jsonObject);

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
