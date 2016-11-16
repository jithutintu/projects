<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<h2>Product</h2>

<form:form action="../edit" method="post">
	<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
		<tr>
			<td>Product ID:</td>
			<td><input class="form-control" type="text" name="product_Id" value="${Product.product_Id}"></td>
		</tr>
		<tr>
			<td>Product Name:</td>
			<td><input class="form-control" type="text" name="product_Name" value="${Product.product_Name}"></td>
		</tr>
		<tr>
			<td>Product Description:</td>
			<td><input class="form-control" type="text" name="description" value="${Product.description}"></td>
		</tr>
		<tr>
			<td>Product Category:</td>
			<td><input class="form-control" type="text" name="category" value="${Product.category}"></td>
		</tr>
		<tr>
			<td>Product Supplier:</td>
			<td><input class="form-control" type="text" name="supplier_Name" value="${Product.supplier_Name}"></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input class="form-control" type="text" name="product_Price" value="${Product.product_Price}"></td>
		</tr>
		<tr>
			<td>Stock:</td>
			<td><input class="form-control" type="text" name="product_Stock" value="${Product.product_Stock}"></td>
			
		</tr>
		<tr>
			<td colspan="2" align="center"><input class="btn btn-success" type="submit" value="Add">
			<input class="btn btn-danger" type="reset" value="Reset"></td>
		</tr>

	</table>

</form:form>