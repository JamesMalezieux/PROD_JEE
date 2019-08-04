<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<p>
<form action="controleur.php" method="post" >
<input type="hidden" value="${model.mode }">
  <table class="table">
  <thead>
    <tr>
      <th scope="col"><input type="text" name="motCle" placeholder="Tapez le mot clé içi"></th>
      <th scope="col"><button type="submit" class="btn btn-outline-primary" value="chercher" name="action">Submit</button></th>
      </tr>
      <tr>
      <th scope="col"><input type="text" name="reference" placeholder="Tapez la référence içi" value="${model.produit.reference }"></th>
      <th scope="col"><input type="text" name="designation" placeholder="Tapez la désignation içi" value="${model.produit.designation }"></th>
      <th scope="col"><input type="text" name="prix" placeholder="Tapez le prix içi" value="${model.produit.prix }"></th>
      <th scope="col"><input type="text" name="quantite" placeholder="Tapez la quantité içi" value="${model.produit.quantite}"></th>
      <th scope="col"><button type="submit" class="btn btn-outline-primary" value="save" name="action">Save</button></th>
    </tr>
      	<tr>
	      <th scope="col" class="table1">Ref</td>
	      <th scope="col" class="table1">Désignation</td>
	      <th scope="col" class="table1">Prix</td>
	      <th scope="col" class="table1">Quantité</td>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${model.produits}" var="p">
  <tr>
	<td>${p.reference}</td>
	<td>${p.designation}</td>
	<td>${p.prix}</td>
	<td>${p.quantite}</td>
	<td><a href="javascript:confirmer('controleur.php?action=delete&ref=${p.reference}')">Del</a></td>
	<td><a href="controleur.php?action=edit&ref=${p.reference}">Edit</a></td>
  </tr>
  </c:forEach>
  </tbody>
</table>
</form>
<div>
${model.errors }
</div>
<script type="text/javascript" src="js/confirm.js"></script>
<%@ include file="footer.jsp" %>