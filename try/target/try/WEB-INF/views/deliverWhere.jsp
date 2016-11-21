<%@include file="/WEB-INF/views/common-header.jsp"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>



<body>
	<c:forEach items="${shippingAddresses}" var="shiipingAddress">
		<div class="address col-lg-2 col-sm-2" style="margin-left: 4em; white-space: nowrap;">


			<h3 style="margin-left: 0.5em; float: left;">${shiipingAddress.name}</h3>

			<a href="#"><span class="glyphicon glyphicon-pencil deliverWhr"></span></a>
			<a  href="#"><span class="glyphicon glyphicon-trash deliverWhr"></span></a>
			<hr style="clear: both;" />
	

		<div>
			<div>${shiipingAddress.address}</div>
			<div>${shiipingAddress.zipCode}</div>
		</div>
		<hr style="margin-top: 3em;">
		<h5>contact No: ${shiipingAddress.phoneNo}</h5>
		<h5>Mail id: ${shiipingAddress.emailid}</h5>
		<hr style="margin-top: 0em;">
		<div class="desc">
		<a href="../paymentMethod/${username}"><button type="submit" name="submit"
				class="btn btn-success">Deliver Here</button></a>
		</div>
	</div>
	</c:forEach>
</body>
