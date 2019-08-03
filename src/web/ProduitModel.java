package web;

import java.util.*;

import metier.Produit;

public class ProduitModel {
private String motCle;
private List<Produit> produit=new ArrayList<Produit>();
public String getMotCle() {
	return motCle;
}
public void setMotCle(String motCle) {
	this.motCle = motCle;
}
public List<Produit> getProduit() {
	return produit;
}
public void setProduit(List<Produit> produit) {
	this.produit = produit;
}


}
