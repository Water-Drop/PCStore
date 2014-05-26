<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>
<%Locale locale1 = new Locale("zh", "CN"); 
ResourceBundle resb1 = ResourceBundle.getBundle("indexStrings", locale1); 
out.println(resb1.getString("welcome")); 
%>


</title>

</head>
<body>
<h2>
<%
Locale locale3 = new Locale("en", "US"); 
ResourceBundle resb3 = ResourceBundle.getBundle("indexStrings", locale3); 
out.println(resb3.getString("welcome")); 
%>
</h2>

</body>
</html>