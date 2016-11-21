

<%@include file="/WEB-INF/views/common-header.jsp"%>



<aside class="col-lg-3 col-sm-4" style="width: 0.333333%;">
	<%@include file="/WEB-INF/views/sidebar.jsp"%>
</aside>
<article class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">

	<c:choose>
		<c:when
			test="${not empty isMyCartClicked || not empty isAddToCartClicked }">
			<%@include file="/WEB-INF/views/myCart.jsp"%>
		</c:when>
		<c:when
			test="${not empty isProductClicked && empty isLoggedInUser}">
			<h1>you have to login first</h1>
		<h1>${username}</h1>
		</c:when>
		<c:when
			test="${not empty isProductClicked && not empty isLoggedInUser}">
			<%@include file="/WEB-INF/views/productDetails.jsp"%>
		</c:when>
		 
		<c:when test="${not empty onLinePaymentClicked}">
			<%@include file="/WEB-INF/views/creditCard.jsp"%>

		</c:when>
		
		<c:when test="${not empty cashOnDeliveryClicked}">
			<%@include file="/WEB-INF/views/shippingAddress.jsp"%>
		</c:when>

		<c:when test="${not empty ProductDelivered}">
			<%@include file="/WEB-INF/views/delivery.jsp"%>
		</c:when>
		
		<c:when test="${not empty isPlaceOrderClicked}">
			<%@include file="/WEB-INF/views/deliverWhere.jsp"%>
		</c:when>
		
		<c:otherwise>
			<%@include file="/WEB-INF/views/listedItem.jsp"%> 
		</c:otherwise>
 
	</c:choose>
 
</article>
