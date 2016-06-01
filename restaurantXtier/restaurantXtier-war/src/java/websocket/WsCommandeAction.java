
package websocket;

public class WsCommandeAction {

    private Long idArticle;
    private String action;
    private String numCommande;

    public WsCommandeAction() {
    }

    public WsCommandeAction(Long idArticle, String action, String numCommande) {
        this.idArticle = idArticle;
        this.action = action;
        this.numCommande = numCommande;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
        this.numCommande = numCommande;
    }
    
    
    
    
}
