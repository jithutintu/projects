<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- <marquee width="140%"> -->
<c:set var="usernames" scope="session" value="${usernames}"/>
<h1>${usernames}</h1> 
  <c:forEach items="${productList}" var="product">

<!-- <article class="col-lg-2 col-lg-offset-1 col-sm-2 col-sm-offset-1" style="margin-top: 20px"> -->


<div class="img col-lg-2 col-lg-offset-1 col-sm-2 col-sm-offset-1" style="margin-top: 20px">
  <a href="<spring:url value="cart/${product.product_Id }"/>">
    <img src="<c:url value="/images/products/${product.product_Id}.png"/>" alt="${product.product_Id}" width="120" height="100">
  </a>
  <div class="desc">
  <ul style="list-style-type:none">
  <li class="span2"><h5 style="color: blue" >${product.product_Name}</h5>
  <h6>Price:${product.product_Price}</h6></li></ul>
  </div>
</div>
<!-- 
</article> -->

</c:forEach> 

<!-- </marquee> -->