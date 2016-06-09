
package websocket;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


public class CommandeDecoder implements Decoder.Text<WsCommandeAction>{

    public CommandeDecoder() {
    }

    @Override
    public WsCommandeAction decode(String s) throws DecodeException {
        System.out.println("+++++decoding");
        System.out.println("String entrante = "+s);
        JsonObject jsonObject = Json.createReader(new StringReader(s)).readObject();
        System.out.println("jsonobject created");
        
        Integer cleCommande =Integer.valueOf(jsonObject.getString("cleCommande"));
        
        System.out.println(cleCommande);
        
        
        
        String action = jsonObject.getString("action");
        System.out.println(action);
     
        Integer roleUser = Integer.valueOf(jsonObject.getString("roleUser"));
        
        
        WsCommandeAction wca = new WsCommandeAction(cleCommande, roleUser, action);
        
        System.out.println(">>>>>>>>>>>>-->>>>>>>>>> WAC = "+ jsonObject);
        
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
        System.out.println("init");
        
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    

    
    
}
