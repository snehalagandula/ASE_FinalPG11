<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import= "java.awt.List"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.lang.String" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crime Report</title>
</head>
<body>
    <table border="1" width="600">
    <tr><td><tb><td>SuspectName</td></b>
    <td><tb>SuspectAlias</b></td>
    <td><tb>suspectaliases</tb></td>
    <td><tb>Height</tb></td>
    <td><tb>suspectht</tb></td>
    <td><tb>Gender</tb></td>
   
    <% Iterator <String> itr;%>
    <%List data =(List)request.getAttribute("datalist");%>
    
 
   </table>
</body>
</html>