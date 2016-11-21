<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<body style="background-color: lavender">
	<title>Bootstrap Example</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@include file="/WEB-INF/views/common-header.jsp" %>
	<style>
	
	
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a href="adminpage56">Track order</a>
				</p>
				<p>
					<a href="#">24x7 Customer Care</a>
				</p>
				<p>
					<a href="#">Offer Zone</a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
				<body style="""lavender">
					<center>
						<h1>Welcome To My Cart</h1>
					</center>
					<hr>
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>

						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
<img src="<c:url value="/images/mobile.jpg"/>"/>
							<div class="carousel-caption"></div>
							</div>
							<div class="item">
								 <img src="<c:url value="/images/dress.jpg"/>"/>
								<div class="carousel-caption"></div>
							</div>

							<div class="item">
								<center>
									<img src="<c:url value="/images/tv.jpg"/>"/>
								</center>
								<div class="carousel-caption"></div>
							</div>

						</div>


						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" role="button"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>


						
					</div>
					
					<center>
							<h4>BigBrand Big Collection</h4>
						</center>
					<marquee>
						<h4>Flat 50% offer on Mens wear</h4>
					</marquee>
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p>
		<h2>Thank you for visiting My cart</h2>
		</p>
	</footer>
	</style>
</body>

</html>
