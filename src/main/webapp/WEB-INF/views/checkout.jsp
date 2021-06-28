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
<c:forEach items="${parkinglist}" var="plist">
<c:forEach items="${zoneitemlist}" var="zlist">
<div>

<h1><a class="checkoutlabel" href="guestcheckoutform?reservationid=${plist.payment.reservationid}&parkinglotid=${plist.parkinglotid}&zonenumber=${zlist.zonenumber}">Guest Checkout</a></h1>

</div>
<div>
<h1><a class="checkoutlabel" href ="customerregistrationform">Create Account</a></h1>
</div>
<!-- <div> -->
<%-- <h1><a href ="login?reservationid=${plist.payment.reservationid}&parkingloid=${plist.parkinglotid}&zonenumber=${zlist.zonenumber}">Login</a></h1> --%>

<!-- </div> -->

<div>
<h1><a  class="checkoutlabel" href ="login?reservationid=${plist.payment.reservationid}&parkinglotid=${plist.parkinglotid}&zonenumber=${zlist.zonenumber}">Login</a></h1>

</div>
</c:forEach>
</c:forEach>
</form>

</body>
</html>