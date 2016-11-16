<html>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:if test="${isAllReadyRegister}">
		<c:set var="s" scope="application" value="11" />
	</c:if>
	<c:if test="${isSignupClicked}">
		<c:set var="s" scope="application" value="12" />
	</c:if>
	
		<c:if test="${s eq 11}">
	<div>
<div class="alert alert-danger  col-xs-3 col-xs-offset-3">
  <strong>${userexists}</strong> 
</div>
 </div></c:if>
 <c:if test="${s eq 12}">
<div class="alert alert-success  col-xs-3 col-xs-offset-3">
  <strong>${success}</strong> 
 
</div>
 </c:if></div>
 	
        <form:form action="register" method="post"
                   commandName="user">
				    <div class="span9 margin-top">
                   <div class="span9 center margin-bottom"> 
					<h3>Registration Form</h3>
					</div>
				   
				  <div class="span3 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">userName</label><form:errors path="name" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
            				<form:input path="name" required="true" id="fullname" class="form-Control" />
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Email</label>
						   <form:errors path="email" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="email" id="email" class="form-Control"/>
						</div>
					  </div>	
					  <div class="control-group">
						<label class="control-label">Password</label>
					     <form:errors path="password" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="password" id="password" class="form-Control"/>
						</div>
					  </div>	
					  <div class="control-group">
						<label class="control-label">Mobile</label>
					     <form:errors path="mobile" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="mobile" id="mobile" class="form-Control"/>
						</div>
					  </div>							  
					  				<div class="control-group">
						<label class="control-label">address</label>
					     <form:errors path="address" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="address" id="address" class="form-Control"/>
						</div>
					  </div>			    
					  					  
					  					  
					  					  </div>
					  		  
					  </div>
					  <div class="span8 center">
					  			<input type="submit" value="submit" class="btn btn-primary"  />
							 <input class="btn btn-danger"
							type="button" value="Cancel"></td>
								</div>
								</form:form>

        
</html>