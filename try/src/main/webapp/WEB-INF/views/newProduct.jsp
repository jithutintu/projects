<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<h2>NewProduct</h2>

<form:form action="newProduct" method="post" enctype="multipart/form-data" >
	<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
		
		
		<tr>
			<td>Product Id:</td>
			<td><input class="form-control" type="text" name="product_Id" required="true"></td>
		</tr>
		<tr>
			<td>Product Name:</td>
			<td><input class="form-control" type="text" name="product_Name" required="true"></td>
		</tr>
		<tr>
			<td>Product Description:</td>
			<td><input class="form-control" type="text" name="description" required="true"></td>
		</tr>
		<tr>
			<td>Product Category:</td>
			<td >
			<select style="width: 50%;" class="form-control" name="category">
			
			<option>Select Category</option>
			<c:forEach items="${categoryList}" var="category">					
			<option value="${category.name}">${category.name}</option>			
			</c:forEach>
			
			</select>			
			</td>
		</tr>
		<tr>
			<td>Product Supplier:</td>
			<td>
			<select style="width: 50%;" class="form-control" name="supplier_Name">
			
			<option>Select Supplier</option>
			<c:forEach items="${supplierList}" var="supplier">					
			<option value="${supplier.name}">${supplier.name}</option>			
			</c:forEach>
			
			</select>			
			
					
			
			</td>
		</tr>
		<tr>
			<td>Product Stock:</td>
			<td><input class="form-control" type="text" name="product_Stock" required="true"></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input class="form-control" type="text" name="product_Price" required="true"></td>
		</tr>
	<td>File to upload:</td> 
				<td><input type="file" name="ItemImage"></td>
					
		<tr>
			<td colspan="2" align="center">
			<input class="btn btn-success" type="submit" value="Add">
			<input class="btn btn-danger" type="reset" value="Reset"></td>
		</tr>

	</table>

</form:form>