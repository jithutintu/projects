<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="manage_supplier" method="post" commandName="supplier">

 <div class="span9" align="center">
<h3>New Supplier Details</h3>

<table>
<tr>
<td>Supplier Name </td><td> : </td> <td> <input type="text" name="suppliername"> </td>
</tr>
<tr>
<td>Supplier PhoneNo </td><td> : </td> <td> <input type="text" name="supplirephone"> </td>
</tr>
<tr>
<td>Supplier Email </td><td> : </td> <td> <input type="text" name="supplieremail"> </td>
</tr>
<tr>
<td>Supplier Address</td><td> : </td> <td> <input type="text" name="supplieraddress"> </td>
</tr>
<td colspan="3"><input type="button" name="submit" value="submit"></td>
</table>
</form:form>
</div>
