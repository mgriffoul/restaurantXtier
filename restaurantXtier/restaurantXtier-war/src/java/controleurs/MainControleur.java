
package controleurs;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MainControleur extends HttpServlet {

   
     private HashMap<String, SousControleurInterface> mp;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        mp = new HashMap<>();
        Enumeration<String> names =  config.getInitParameterNames();
        while(names.hasMoreElements()){
            String nom = names.nextElement();            
            String valeur = config.getInitParameter(nom);
            try {
                SousControleurInterface sc = (SousControleurInterface) Class.forName(valeur).newInstance();
                mp.put(nom, sc);
            } catch (ClassNotFoundException ex) {
                System.out.println("----->> oups : " + ex.getMessage());
            } catch (InstantiationException ex) {
                
            } catch (IllegalAccessException ex) {
                
            }
        }       
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String prefixe = "/WEB-INF/";
        String suffixe = ".jsp";
        String url = "/include/login";
        String section = request.getParameter("section");

        System.out.println(">>>>>>>>>>>>>>>>>"+ section);
        if (section != null && mp.containsKey(section)) {

            SousControleurInterface sc = mp.get(section);
            url = sc.execute(request, response);         
        }
        
        url = response.encodeURL(prefixe + url + suffixe);
        System.out.println(">>>>>>>>url>>>>>>>>>"+ url);
        getServletContext().getRequestDispatcher(url).include(request, response);
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
