<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
</head>
<style>
.navbar-default .navbar-text {
  color: #999;
}
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
</style>
<body>
	<c:if test="${ch}">
		<c:set var="s" scope="application" value="0" />
	</c:if>

	<c:if test="${adminhello}">
		<c:set var="s" scope="application" value="1" />
	</c:if>

	<c:if test="${ch1}">
		<c:set var="s" scope="application" value="0" />
	</c:if>

	<c:if test="${adminlogcheck}">
		<c:set var="s" scope="application" value="2" />
</c:if>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="adminpage56">My Cart</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				
			
			<li><a href="adminpage56"><span class="glyphicon glyphicon-log-in"></span>Home12</a></li>



				</ul>
				<ul class="nav navbar-nav navbar-right">
				
				
				<c:if test="${s eq 2}">
				
					<li><a href="myCart/${username}"><span class="glyphicon glyphicon-shopping-cart ">
					</span>MyCart(${numberOfProduct})</a></li>
				</c:if>
				
				<c:if test="${s eq 2}">
			<li><a style = "color:white">Welcome ${emails }</a></li>
						<li style="display: inline-block"><a href="logout"><span
								class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
				</c:if>
				
					<c:if test="${s eq 1}">
						<li>  <a style = "color:white"  >Welcome ${username }</a></li>
					</c:if>
					
					<c:if test="${s eq 1}">
					
						<li style="display: inline-block"><a href="logout"><span
								class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
								
					</c:if>
					
					
					
					<c:if test="${s eq 0}">
					
					
						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
<li><a href="<c:url value="/register" />"><span
							class="glyphicon glyphicon-share">Sign Up</a></span></li>
							
							
					</c:if>
					
				</ul>
			</div>
		</div>
	</nav>
	
	
</body>

</html>