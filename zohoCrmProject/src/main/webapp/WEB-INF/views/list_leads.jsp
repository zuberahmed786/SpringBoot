<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leads List</title>
</head>
<body>
<h2>Lead List</h2>

<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Source</th>
<th>Delete</th>
<th>Update</th>
<th>Billing</th>
</tr>

 <c:forEach var="lead" items="${leads}">
 
 <tr>
 <td><a href="findLeadById?id=${lead.id}">${lead.firstName}</a></td>
 <td>${lead.lastName}</td>
 <td>${lead.email}</td>
 <td>${lead.mobile}</td>
 <td>${lead.source }</td>
 <td><a href="delete?id=${lead.id }">delete</a></td>
 <td><a href="update?id=${lead.id }">update</a></td>
 <td><a href="generateBill?id=${lead.id}">Generate Bill</a></td>
 </tr>
 
 </c:forEach>

</table>
</body>
</html>