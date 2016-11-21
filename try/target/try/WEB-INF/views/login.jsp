<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <c:if test="${login}">
		<c:set var="s" scope="application" value="9" />
	</c:if>
	
	<c:if test="${logout}">
		<c:set var="s" scope="application" value="10" />
	</c:if>
	
	<div>
	<c:if test="${s eq 9}">
<div class="alert alert-danger  col-xs-3 col-xs-offset-3">
  <strong>${errormessage}</strong> 
</div>
 </c:if></div>
 
 <div>
	<c:if test="${s eq 10}">
<div class="alert alert-success  col-xs-3 col-xs-offset-3">
  <strong>${errormessage1}</strong> 
</div>
 </c:if></div>
 
 
 
<table>  

<div class="container-fluid">


<form:form action="login" method="post" class="form-horizontal">
	

	
	<tr>
		<td class= "colspan=5 align= "><h3>Login Here</h3></td>
		</tr>
	
		
      
   <!--   <h3> <p class="text-center"><strong><mark>${errormessage}</mark></strong></p></h3>-->
  <!--  <tr>
			<td colspan="2" align="center"><b><h4 class="bg-red">${errormessage}</h4></b></td>
				</tr>
-->
			<tr>
				<td class="col-xs-5 "><b>UserName:</b></td>
				<td><input class="form-control" type="text" name="email" placeholder="Enter YouR Email Id"></td>
			</tr>
		
			
		

<br>
			<tr>
				<td class="col-xs-5 "><b>Password:</b></td>
				<td> <input class="form-control" type="password" name="password" placeholder="Enter password"/></td>
			</tr>
			 
					</table>
			<table>
			<tr>
				<td class="col-lg-3 col-offset-3 col-sm-3 col-sm-offset-3"><a href="register">New User?</a></td>
				</tr>
				<tr>
				 <td class="col-lg-3 col-offset-3 col-sm-3 col-sm-offset-3">
				<input type="submit" class="btn btn-success ">
				<a href="home"class="btn btn-danger">Cancel</a>
				</td>
				</tr>
				
			
	
	</form:form>
	</table>
	
	</div>