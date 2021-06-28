<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
<link rel=stylesheet href="resources/home.css" type="text/css">
</head>
<body id="checkoutpagebody">
<form>
<c:forEach items="${parkinglistcity}" var="plist">
<c:forEach items="${zoneitemlistcity}" var="zlist">
<div>

<h1><a href="guestcheckoutformbycity?reservationid=${plist.payment.reservationid}&parkinglotid=${plist.parkinglotid}&city=${zlist.city}">Guest Checkout</a></h1>

</div>
<div>
<h1><a href ="customerregistrationformbycity">Create Account</a></h1>
</div>
<!-- <div> -->
<%-- <h1><a href ="login?reservationid=${plist.payment.reservationid}&parkingloid=${plist.parkinglotid}&zonenumber=${zlist.zonenumber}">Login</a></h1> --%>

<!-- </div> -->

<div>
<h1><a href ="loginbycity?reservationid=${plist.payment.reservationid}&parkinglotid=${plist.parkinglotid}&city=${zlist.city}">Login</a></h1>

</div>
</c:forEach>
</c:forEach>
</form>

</body>
</html>