
package websocket;

public class WsCommandeAction {

   private Integer cleCommande;
   private String action;

    public WsCommandeAction() {
    }

    public WsCommandeAction(Integer cleCommande, String action) {
        this.cleCommande = cleCommande;
        this.action = action;
    }

    public Integer getCleCommande() {
        return cleCommande;
    }

    public void setCleCommande(Integer cleCommande) {
        this.cleCommande = cleCommande;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
   
   

    
    
   
    
    
}
