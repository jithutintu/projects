<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/common-header.jsp" %>
<h2 style="font-family: magneto" >Edit Category</h2>

	<form:form action="../editcategory" method="post">
		<table align="center" class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">
			<tr>
				<td>Category ID:</td>
				<td><input class="form-control" type="text" name="id" value="${category.id}"></td>
			</tr>
			<tr>
				<td>Category Name:</td>
				<td><input class="form-control" type="text" name="name" value="${category.name}"></td>
			</tr>
			<tr>
				<td>Category Description:</td>
				<td><input class="form-control" type="text" name="description" value="${category.description}"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input class="btn btn-success" type="submit" name="submit" value="Edit"></a>
				<input class="btn btn-danger" type="reset" value="Reset"></td>
			</tr>
			
		</table>

	</form:form>
	

	
