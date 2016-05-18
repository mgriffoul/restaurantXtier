
package controleurs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface SousControleurInterface {
    
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
