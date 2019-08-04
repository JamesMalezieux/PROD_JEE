package web;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.ICatalogueMetier;
import metier.Produit;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private ICatalogueMetier metier; 
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException{
		metier=new CatalogueMetierImpl();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProduitModel model=new ProduitModel();
		request.setAttribute("model", model);
		String action=request.getParameter("action");
		if(action != null) {
		if(action.equals("chercher")) {
			model.setMotCle(request.getParameter("motCle"));
			List<Produit> produits=metier.ProduitsParMC(model.getMotCle());
			model.setProduits(produits);
		}
		else if(action.equals("delete")) {
			String ref=request.getParameter("ref");
			metier.deleteProduit(ref);
			model.setProduits(metier.listProduits());
		}
		else if(action.equals("edit")) {
			String ref=request.getParameter("ref");
			Produit p=metier.getProduit(ref);
			model.setProduit(p);
			model.setMode("edit");
			model.setProduits(metier.listProduits());
			
		}
		else if(action.equals("save")) {
			try {
				model.getProduit().setReference(request.getParameter("reference"));
				model.getProduit().setDesignation(request.getParameter("designation"));
				model.getProduit().setPrix(Double.parseDouble(request.getParameter("prix")));
				model.getProduit().setQuantite(Integer.parseInt(request.getParameter("quantite")));
				model.setMode(request.getParameter("mode"));
				if(model.getMode().equals("ajout")) {
				metier.addProduit(model.getProduit());
				}
				else if(model.getMode().equals("edit")) {
					metier.updateProduit(model.getProduit());
					}
				model.setProduits(metier.listProduits());
			}catch(Exception e) {
				model.setErrors(e.getMessage());
			}	
		}
	}
		request.getRequestDispatcher("VueProduits.jsp").forward(request, response);

}
	}
