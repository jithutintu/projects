<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<article class="col-lg-8 col-lg-offset-1 col-sm-7 col-sm-offset-1">

	<c:choose>
		<c:when
			test="${not empty isMyCartClicked || not empty isAddToCartClicked }">
			<%@include file="/WEB-INF/views/myCart.jsp"%>
		</c:when>
		
		<c:when
			test="${not empty isProductClicked && not empty isLoggedInUser}">
			<%@include file="/WEB-INF/views/productDetails.jsp"%>
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
