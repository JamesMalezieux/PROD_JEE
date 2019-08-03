package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		ICatalogueMetier metier=new CatalogueMetierImpl();
		/* ajout de produits
		metier.addProduit(new Produit("01", "AA", 450, 3));
		metier.addProduit(new Produit("02", "AB", 670, 3));
		metier.addProduit(new Produit("03", "AC", 2678, 3));
		metier.addProduit(new Produit("04", "AD", 56, 3));
		metier.addProduit(new Produit("05", "AE", 870, 3));
		metier.addProduit(new Produit("06", "AF", 570, 6));
		metier.addProduit(new Produit("07", "AG", 1079, 10));
		metier.addProduit(new Produit("08", "AH", 900, 30));
		metier.addProduit(new Produit("09", "AA", 450, 3));
		metier.addProduit(new Produit("10", "AB", 670, 3));
		metier.addProduit(new Produit("11", "AC", 2678, 3));
		metier.addProduit(new Produit("12", "AD", 56, 3));
		metier.addProduit(new Produit("13", "AE", 870, 3));
		metier.addProduit(new Produit("14", "AF", 570, 6));
		metier.addProduit(new Produit("15", "AG", 1079, 10));
		metier.addProduit(new Produit("16", "AH", 900, 30));
		System.out.println("ajout terminée");*//*
	
		List<Produit> prods=metier.listProduits();
		for(Produit p:prods) {
			System.out.println("---Liste de produits---");
			System.out.println(p.getReference());
			System.out.println(p.getDesignation());
			System.out.println(p.getPrix());
			System.out.println(p.getQuantite());
			System.out.println("***********************");
		}*//*
		
		List<Produit> prods0=metier.ProduitsParMC("AH");
		for(Produit p:prods0) {
			System.out.println("---Produit par MC---");
			System.out.println(p.getDesignation());
		}*/
		/*
		System.out.println("---Consulter un produit---");
		try {
			Produit p=metier.getProduit("02");
			System.out.println(p.getDesignation());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		*/
		/*
		System.out.println("---UPDATE---");
		try {
			Produit p=metier.getProduit("02");
			p.setPrix(9000);
			metier.updateProduit(p);
			Produit p2=metier.getProduit("02");
			System.out.println(p2.getPrix());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("---DELETE---");
		System.out.println("suppression en cours");
		metier.deleteProduit("05");
		System.out.println("suppression OK");
	} */
	} 
}
