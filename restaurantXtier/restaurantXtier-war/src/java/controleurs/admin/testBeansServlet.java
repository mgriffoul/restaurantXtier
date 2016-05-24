package controleurs.admin;

import beanEntite.Categorie;
import beanEntite.LigneCommande;
import beanEntite.SousCategorie;
import beansSession.BeanCategorieLocal;
import beansSession.BeanLigneCommandeLocal;
import beansSession.BeanSousCategorieLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testBeansServlet extends HttpServlet {

    @EJB
    private BeanCategorieLocal categorie;

    @EJB
    private BeanSousCategorieLocal sousCate;
    
    @EJB
    private BeanLigneCommandeLocal ligneCom;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //TEST CATEGORIE BEAN
            System.out.println(categorie.selectCategorieById(1L));
            System.out.println(categorie.selectCategorieByNom("Les Entrées"));

            List<Categorie> categories = categorie.selectAllCategorie();
            for (Categorie c : categories) {
                System.out.println("List " + c);
            }

            List<SousCategorie> souscates = categorie.selectSousCategorieByIdCategorie(3L);
            for (SousCategorie s : souscates) {
                System.out.println("sousCate by id cate " + s);
            }

        //test sous cate bean
            System.out.println("sous cate by id" + sousCate.selectSousCategorieById(3L));
            List<SousCategorie> souscategories = sousCate.selectAllSousCategorie();
            for (SousCategorie s : souscategories) {
                System.out.println("all sous cate " + s);
            }
            System.out.println(sousCate.selectSousCategorieByNom("Antipasti"));

            List<SousCategorie> sousCateL = sousCate.selectAllSousCategorieByCategorieId(3L);
            for (SousCategorie s : sousCateL) {
                System.out.println("sous cate by cate id 2" + s);
            }
            
        // test affichage ligne commande where idCat=    
            System.out.println("=======DEBUT AFFICHAGE LC BY IDCAT =======");
            List<LigneCommande> lcs = ligneCom.selectLigneCommandeByIdCategorie(2L);
            for (LigneCommande lc : lcs){
                String p= lc.getArticle().getNom();
                String e= lc.getEtat();
                String c= lc.getArticle().getSousCategorie().getCategorie().getNom();
                System.out.println(c+" - "+p+" - "+e);
            }
            System.out.println("===== FIN =======");
            request.setAttribute("message", "fin des tests");
            getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/testDesBeans.jsp")).include(request, response);

        }
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
