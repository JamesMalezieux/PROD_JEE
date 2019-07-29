package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class CatalogueMetierImpl implements ICatalogueMetier{

	@Override
	public void addProduit(Produit p) {
		Connection conn=SingletonConnectionne.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into PRODUITS values (REF_PROD, DESIGNATION, PRIX, QUANTITE)");
			ps.setString(1, p.getReference());
			ps.setString(2, p.getDesignation());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> listProduits() {
		List<Produit> prods=new ArrayList<Produit>();/*instance de la liste de produit*/
		Connection conn=SingletonConnectionne.getConnection(); /*conncetion*/
		try {
			PreparedStatement ps=conn.prepareStatement("select * from PRODUITS");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("REF_PROD"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public List<Produit> ProduitsParMC(String mc) {
		List<Produit> prods=new ArrayList<Produit>();/*instance de la liste de produit*/
		Connection conn=SingletonConnectionne.getConnection(); /*conncetion*/
		try {
			PreparedStatement ps=conn.prepareStatement("select * from PRODUITS where DESIGNATION like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("REF_PROD"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Produit getProduit(String ref) {
		Produit p= null;
		Connection conn=SingletonConnectionne.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from PRODUITS where REF_PROD=?");
			ps.setString(1, ref);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p= new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("REF_PROD"));
				p.setQuantite(rs.getInt("QUANTITE"));	
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(p==null)throw new RuntimeErrorException(null, "Produit introuvable");
		return p;
	}
	@Override
	public void updateProduit(Produit p) {
		
	}

	@Override
	public void deleteProduit(String ref) {
		
	}
	
}
