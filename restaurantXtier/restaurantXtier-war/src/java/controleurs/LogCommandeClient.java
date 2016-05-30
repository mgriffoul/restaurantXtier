
package controleurs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogCommandeClient implements SousControleurInterface{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        HttpSession session = request.getSession();
    
        //********
        //Preparation des URL 
        //********************
        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";

        //URL par défaut
        String url = "include/IHM_Client/index";
    
        
        
        
        
        
        
        
        request.setAttribute("contentInc", prefix + s1 + suffix);
        return url;
    
    }
    
    
    
}
