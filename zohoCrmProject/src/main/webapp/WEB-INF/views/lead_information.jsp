<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Information</title>
</head>
<body>
<h2>Lead Information</h2>

First Name: ${lead.firstName }<br/>
Last Name: ${lead.lastName }<br/>
     Email: ${lead.email }<br/>
     Mobile: ${lead.mobile }<br/>
     Source: ${lead.source }<br/>
     
     <form action="composeEmail" method="post">
     <input type="hidden" name="email" value="${lead.email }"/>
     <input type="submit" value="send eamil"/> 
     
     </form>
     
      <form action="convertLead" method="post">
     <input type="hidden" name="id" value="${lead.id }"/>
     <input type="submit" value="Convert"/> 
     
     </form>
        <form action="listAll" method="post">
     <input type="hidden" />
     <input type="submit" value="List Of Leads"/> 
     
     </form>
</body>
${message}
</html>