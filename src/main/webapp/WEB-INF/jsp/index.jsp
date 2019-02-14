<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
    <h1>List of stocks</h1>

    <c:forEach var="stock" items="${page}">
        <li>${stock}</li>
    </c:forEach>



</body>

</html>