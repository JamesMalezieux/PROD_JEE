package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		ICatalogueMetier metier=new CatalogueMetierImpl();
		/* ajout de produits
		metier.addProduit(new Produit("REF05", "AA", 870, 3));
		metier.addProduit(new Produit("REF06", "BB", 570, 6));
		metier.addProduit(new Produit("REF07", "CC", 1079, 10));
		metier.addProduit(new Produit("REF08", "DD", 900, 30));
	*/
		List<Produit> prods=metier.listProduits();
		for(Produit p:prods) {
			System.out.println("---Liste de produits---");
			System.out.println(p.getReference());
			System.out.println(p.getDesignation());
			System.out.println(p.getPrix());
			System.out.println(p.getQuantite());
		}
		List<Produit> prods0=metier.ProduitsParMC("HP");
		for(Produit p:prods0) {
			System.out.println("---Produit par MC---");
			System.out.println(p.getDesignation());
		}
		System.out.println("---Consulter un produit---");
		Produit p=metier.getProduit("PR02");
		System.out.println(p.getDesignation());
	}

}
