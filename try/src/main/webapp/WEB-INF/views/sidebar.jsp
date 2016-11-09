<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


  <br>
  <table class="sidev">
  <c:forEach items="${categoryList}" var="category">
  <tr >
  <td><a href="viewproduct/${category.name}">${category.name}</a></td>
  </tr>
  </c:forEach>
  
  </table>
</nav>

