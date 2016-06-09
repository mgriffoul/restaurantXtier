
package websocket;

import java.math.BigDecimal;
import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class CommandeEncoder implements Encoder.Text<WsCommandeAction>{

    @Override
    public String encode(WsCommandeAction wca) throws EncodeException {
        System.out.println("ENCODE +++++++");
        return Json.createObjectBuilder()
                        .add("action", wca.getAction())
                        .add("cleCommande", wca.getCleCommande())
                        .add("password", wca.getPassword())
                   .build().toString();
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
