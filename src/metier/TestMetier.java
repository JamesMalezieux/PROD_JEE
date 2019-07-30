package metier;

public class TestMetier {

	public static void main(String[] args) {
		ICatalogueMetier metier=new CatalogueMetierImpl();
		metier.addProduit(new Produit("REF05", "AA", 870, 3));
		metier.addProduit(new Produit("REF06", "BB", 570, 6));
		metier.addProduit(new Produit("REF07", "CC", 1079, 10));
		metier.addProduit(new Produit("REF08", "DD", 900, 30));

	}

}
