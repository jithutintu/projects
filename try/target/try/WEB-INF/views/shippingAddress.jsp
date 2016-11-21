<%@include file="/WEB-INF/views/common-header.jsp" %>

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<div ng-app="">

<div style="margin-right: 15em;" align="center" >
	<form:form method="post" action="../shiipingAddess/${username}" onsubmit=" ">
		<table align="center">
		<tr>
		<td colspan="1" align="center"><h3>Shipping Address </h3></td>
		</tr>
			
			<tr>
				<td>User Name :</td>			
				<td><input class="form-control" type="text" name="name" id="user" value="${User.username}"/>
			</tr>
			
			<tr>
				<td>Phone Number :</td>				
				<td><input class="form-control" type="text" name="phoneNo" id="ph" value="${User.phoneNo}"/>
			</tr>
			<tr>
				<td>Email id :</td>				
				<td><input class="form-control" type="email" name="emailid" id="email" value="${User.emailid}"/>
			</tr>
			<tr>
				<td>Address :</td>				
				<td><input class="form-control" type="text" name="address" id="address" value="${User.adress}"/></td>
			</tr>
			
			<tr>
				<td>Zipcode :</td>			
				<td><input class="form-control" type="text" name="zipCode" id="zip" value="${User.zipCode}"/></td>
			</tr>
			<tr>
				
				<td align="left">
				<input class="btn btn-success" type="submit" value="submit" >
				<input class="btn btn-danger" type="button" value="Cancel"></td>
			</tr>
		</table>
	</form:form>
	</div>
	</div>