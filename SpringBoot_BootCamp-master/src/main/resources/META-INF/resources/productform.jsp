<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
<form action="/api/products">
 Name <input name=name> <br> 
 Price<input name=Price><br>
 qOH<input name=qoh><br> <input name=submit value="submit" type=submit> 
    </form>

</body>
</html>