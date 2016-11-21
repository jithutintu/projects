<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script>
function goBack() {
    window.history.back();
}
</script>
<style>
.view
{
    
}
</style>
</head>


<%@include file="/WEB-INF/views/common-header.jsp" %>
<body>


<table  width="100%" class="view table table-bordered">
<tr>
<td colspan = "6" align="center"><h4 >List of available categories</h4></td>
</tr>
	<tr>
	    
	    <th align="left">S.No</th>
	
	
		<th align="left">ProductName</th>
		
		<th align="left">Quantity</th>
		<th align="left">Price</th>
        <th align="left">Proceed
		<th align="left">Delete</th>		
	</tr>
	<c:forEach items="${cartList}" var="cart" varStatus="status">
		<tr>
			<td>${status.count}</td>
			
			<td>${cart.productName}</td>		
			<td>${cart.quantity}</td>
				<td>${cart.price}</td>
			<td><a href="proceed/${cart.productName}">Proceed</a></td> 
			<td><a href="<c:url value='deletecart/${cart.productName}' />" onclick="return confirm('Are You Sure? Do you Want Delete Produt : ${cart.productName} ?')">delete</a></td>
		
		
		</tr>
	</c:forEach>
	<tr style="margin-top: 3px">
	<td colspan="3" align = "right" margin-right= "-30px">Total Amount :</td>
	<td colspan="2">${total}</td>
	</tr>
	
</table>

<button  onclick="goBack()">Go Back</button>

<a href="../Proceed/${username}"><button type="button" name="button" class="btn btn-success"> Place Order </button></a>

<div class="dropdown" style="margin-left: 8em;">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Proceed<span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="../onLinePayment/${username}">On Line Payment</a></li>
    
      <li class="divider"></li>
      <li><a href="../cashOnDelivery/${username}">Cash On Delivery</a></li>
    </ul>
  </div>
  
  </div>
  </body>
