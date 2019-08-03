<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<p>
<form action="controleur.php" method="post" >
  <table class="table">
  <thead>
    <tr>
      <th scope="col"><input type="text" name="motCle" placeholder="Tapez le mot clé içi"></th>
      <th scope="col"><button type="submit" class="btn btn-outline-primary">Submit</button></th>
    </tr>
      	<tr>
	      <th scope="row">#</th>
	      <th scope="col">Ref</td>
	      <th scope="col">Désignation</td>
	      <th scope="col">Prix</td>
	      <th scope="col">Quantité</td>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${model.produit}" var="p">
  <tr>
	<th scope="row">-</th>
	<td>${p.reference}</td>
	<td>${p.designation}</td>
	<td>${p.prix}</td>
	<td>${p.quantite}</td>
  </tr>
  </c:forEach>

  </tbody>
</table>
</form>
<%@ include file="footer.jsp" %>