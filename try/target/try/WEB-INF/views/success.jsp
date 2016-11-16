<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="span9" >
<form:form action="aftersuccess" method="post" >
RegisteredSuccessfully


<c:if test="${isSignupClicked}">
		<c:set var="s" scope="application" value="12" />
	</c:if>
	
 	<c:if test="${s eq 12}">
<div class="alert alert-success  col-xs-3 col-xs-offset-3">
  <strong>${isSignupClicked}</strong> 
 
</div>
 </c:if></div>
<div class="span5">

             <div class="col-lg-5  col-sm-4 ">
			<div class="text-center"><h3 class="text-danger">Click Here To... <a href="aftersuccess" class="btn btn-warning" role="button"> continue  shopping </a>
				
				
				</div>	
</div>
</form:form>
</body>
</html>