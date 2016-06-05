
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
        
        /*private Long idArticle;
    private String action;
    private String numCommande;*/
        
        JsonObject jsonObject = Json.createReader(new StringReader(s)).readObject();
        Integer idArticle =jsonObject.getInt("idArticle");
        System.out.println(idArticle);
        String action = jsonObject.getString("action");
        System.out.println(action);
        String numCommande = jsonObject.getString("numCommande");
        System.out.println(numCommande);
        WsCommandeAction wca = new WsCommandeAction(2L, action, numCommande);
        
        System.out.println(">>>>>>>>>>>>-->>>>>>>>>> WAC = "+idArticle+action+numCommande);
        
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
