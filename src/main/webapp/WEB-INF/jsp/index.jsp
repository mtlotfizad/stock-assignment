<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">

<body>
<h1>List of stocks</h1>
<table border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="10%">ID</th>
        <th width="15%">Name</th>
        <th width="10%">Current Price</th>
        <th width="10%">Last Update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stock" items="${resultSet.content}">
        <tr>
            <td>${stock.id}</td>
            <td>${stock.name}</td>
            <td>${stock.currentPrice}</td>
            <td>${stock.lastUpdate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${!resultSet.first}">
    <li class="prev">
        <a href="?page=${resultSet.number-1}">Previous &larr;</a>
    </li>
</c:if>
<p/>
<c:if test="${!resultSet.last}">
    <li class="next">
        <a href="?page=${resultSet.number+1}">Next &rarr;</a>
    </li>
</c:if>

</body>

</html>