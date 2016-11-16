<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/views/common-header.jsp" %>


<h2 style="font-family: magneto" align="center">ADD Supplier</h2>
<div class ="row">
	<form:form action="newSupplier" method="post">
		<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
			
			
			<tr>
				<td>Supplier Id:</td>
				<td><input class="form-control" type="text" name="id" required="true"></td>
			</tr>
			
			<tr>
				<td>Supplier Name:</td>
				<td><input class="form-control" type="text" name="name" required="true"></td>
			</tr>
			<tr>
				<td>Supplier Mobile:</td>
				<td><input class="form-control" type="text" name="contact" required="true"></td>
			</tr>
			<tr>
				<td>Supplier emailId:</td>
				<td><input class="form-control" type="email" name="email" required="true"></td>
			</tr>
			<tr>
				<td>Supplier Address:</td>
				<td><input class="form-control" type="text" name="address" required="true"></td>
			</tr>

	
		    <br>
			<br>
				<td  colspan="2" align="center"><input class="col-xs-offset-4 btn btn-success" type="submit" value="Add">
				<input class="btn btn-danger" type="reset" value="Reset"></td>
			
			</table>
		
		

	</form:form></div>
