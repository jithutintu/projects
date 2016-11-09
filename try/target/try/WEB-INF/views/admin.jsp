
<body style="background-color: #FFE8D0">
<%@include file="/WEB-INF/views/common-header.jsp" %>

 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<br>
<br>
<br>

  <h2>Admin Control</h2>
  
  <table class="table table-bordered">
    <thead>
      <th  class="success col-lg-3 col-lf-offset-1 col-sm-3 col-sm-offset-1">
      <div class="container">
    <div class="row row-centered">
     
<div class="text-center"><h3 class="text-danger">Manage Categories: <a href="viewCategories" class="btn btn-warning" role="button"> View </a>  |  <a href="addcategory" class="btn btn-info" role="button" >ADD</a> <br></h3></div>
<div class="text-center"><h3 class="text-green">Manage Products  : <a href="viewProducts"class="btn btn-warning" role="button">   View </a>  | <a href="addproduct"class="btn btn-info" role="button"> Add</a>  <br></h3></div>
<div class="text-center"><h3 class="text-warning">Manage Suppliers : <a href="viewSuppliers"class="btn btn-warning" role="button">  View </a>  | <a href="addsupplier"class="btn btn-info" role="button">Add</a>  </br></h3></div>
<c:if test="${not empty isAddCategoryClicked}">
</c:if>
<c:if test="${not empty isViewCategoriesClicked}">
</c:if>

</div>
</div>
</div>
 
</th>

    </thead>
    
  </table>
</div>

</body>
</html>
