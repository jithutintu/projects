<html>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1"><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/common-header.jsp" %>

<link rel="stylesheet"
		href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.btn btn-success
{
  text-align:center;
  margin-bottom: -40px;
}
</style>
<h2 style="font-family: magneto" align="center">ADD Category</h2>

	<form:form action="newCategory" method="post" onsubmit="return formCategory()">
		<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
			<tr>
			<td>Category Id:</td>
			<td><input class="form-control" type="text" name="id" id="categoryId"></td>
			</tr>
			<tr>
				<td>Category Name:</td>
				
				<td><input class="form-control" type="text" name="name" id="categoryName"></td>
			</tr>
			<tr>
				<td>Category Description:</td>
				<td><input class="form-control" type="text" name="description" id="description"></td>
			</tr><br>
 
			<tr>
				<td colspan="2" align="center" btn-bottom="-100px"><input class="btn btn-success" btn- type="submit" value="Add">
				<input class="btn btn-danger" type="reset" value="Reset"></td>
			</tr>
			
		</table>

	</form:form>
</html>