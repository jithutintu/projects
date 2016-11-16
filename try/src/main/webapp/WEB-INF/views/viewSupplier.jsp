<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<h4 class=" text-danger ">List of available Suppliers</h4>
<body style="background-color: #F0E68C">
<table class= " table table-bordered  table table-hover"  >
	<tr class= "SUCCESS" >
	    <th align="left">S.No</th>
		<th align="left">Id</th>
		<th align="left">Name</th>
		<th align="left">contact</th>
		<th align="left">Email</th>
		<th align="left">Address</th>
		<th align="left">Edit</th>
		<th align="left">Delete</th>
	</tr>
	<c:forEach items="${supplierList}" var="supplier" varStatus="status">
		<tr class= primary>
			<td>${status.count}</td>
			<td>${supplier.id}</td>
			<td>${supplier.name}</td>
			<td>${supplier.contact}</td>
			<td>${supplier.email}</td>
			<td>${supplier.address}</td>
			<td><a href="editSupplier/${supplier.id}">Edit</a></td>
			<td><a href="deleteSupplier/${supplier.id}" onclick="return confirm('Are you Sure? Do you Want Delete Supplier : ${supplier.name} ?')">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>