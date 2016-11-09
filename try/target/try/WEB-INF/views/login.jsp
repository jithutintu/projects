<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  <table >
  
  ${errors }
<div style="margin-left:30%" align="center">
<form:form action="login" method="post" class="form-horizontal">
	
		<table class="col-lg-3 col-lg-offset-4 col-sm-9 col-sm-offset-5" "table table-bordered">
	
	<tr>
		<td colspan="5" align="justify"><h3>Login Here</h3></td>
		</tr>

			<tr>
				<td class="col-lg-3 col-lf-offset-1 col-sm-3 col-sm-offset-1"><b>UserName:</b></td>
				<td><input class="form-control" type="text" name="email"></td><br><br><br>
			</tr>

<br>
			<tr>
				<td class="col-lg-3 col-lf-offset-1 col-sm-3 col-sm-offset-1"><b>Password:</b></td>
				<td> <input class="form-control" type="password" name="password" /></td>
			</tr>
			 <c:if test="${empty errors}">
			<div class="ch1">${ch1}</div>
	 </c:if> 
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
				<tr>
				<td colspan="2" align="center"><b>${message}</b></td>
				</tr>
			<tr>
				<td class="col-lg-3 col-lf-offset-1 col-sm-3 col-sm-offset-1"><a href="register">New User?</a></td>
				<td align="center">
				 <div class="col-lg-5  col-sm-4 ">
				<input type="submit" class="btn btn-success">
				<b></b>
				<a href="index"class="btn btn-danger">Cancel</a>
				</div>
				
			
				
			</tr>
			
		</table>
	</form:form>
	</div>