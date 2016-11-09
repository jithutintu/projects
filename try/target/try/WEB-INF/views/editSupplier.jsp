<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>Product</h2>


<form:form action="../editSupplier" method="post">
	<table>
		<tr>
			<td>Supplier ID:</td>
			<td><input type="text" name="id" value="${supplier.id} "></td>
		</tr>
		<tr>
			<td>Supplier Name:</td>
			<td><input type="text" name="name" value="${supplier.name}"></td>
		</tr>
		<tr>
			<td>Supplier PhoneNo:</td>
			<td><input type="text" name=contact value="${supplier.contact}"></td>
		</tr>
		<tr>
			<td>Supplier EmailId:</td>
			<td><input type="text" name="email" value="${supplier.email}"></td>
		</tr>
		<tr>
			<td>Supplier Address:</td>
			<td><input type="text" name="address" value="${supplier.address}"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Add">
			<td><input type="reset" value="Reset">
		</tr>

	</table>

</form:form>