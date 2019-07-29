package metier;

import java.util.List;

public interface ICatalogueMetier {

	public void addProduit(Produit p);
	public List<Produit> listProduits();
	public List<Produit> ProduitsParMC(String mc);
	public Produit getProduit(String ref);
	public void updateProduit(Produit p);
	public void deleteProduit(String ref);
	
}
