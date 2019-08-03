<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<p>
<form action="controleur.php" method="post" >
  <table class="table">
  <thead>
    <tr>
      <th scope="col"><input type="text" name="motCle" placeholder="Tapez le mot cl� i�i"></th>
      <th scope="col"><button type="submit" class="btn btn-outline-primary" value="chercher" name="action">Submit</button></th>
    </tr>
      	<tr>
	      <th scope="row" class="table1">#</th>
	      <th scope="col" class="table1">Ref</td>
	      <th scope="col" class="table1">D�signation</td>
	      <th scope="col" class="table1">Prix</td>
	      <th scope="col" class="table1">Quantit�</td>
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
	<td><a href="controleur.php?action=delete&ref=${p.reference}">Delete</a></td>
  </tr>
  </c:forEach>
  </tbody>
</table>
</form>
<%@ include file="footer.jsp" %>