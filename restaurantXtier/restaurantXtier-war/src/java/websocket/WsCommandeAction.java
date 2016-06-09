
package websocket;

public class WsCommandeAction {

   private Integer cleCommande;
   private Integer roleUser;
   private String action;

    public WsCommandeAction() {
    }

    public void setRoleUser(Integer roleUser) {
        this.roleUser = roleUser;
    }

    public WsCommandeAction(Integer cleCommande, Integer roleUser, String action) {
        this.cleCommande = cleCommande;
        this.roleUser = roleUser;
        this.action = action;
    }

    public Integer getRoleUser() {
        return roleUser;
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
