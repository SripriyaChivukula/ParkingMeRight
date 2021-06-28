<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ParkBy City results</title>
<link rel=stylesheet href="resources/home.css" type="text/css">
</head>
<body id="parkbycityresultspage">
<form>
 <table border="1" cellpadding="5" id="parkbycityresultspagetable">
 <tr>
 <th>City</th>
 <th>Zone Number</th>
 <th>ParkingLot ID</th>
 <th>ParkingLot Number</th>
 <th>Availability</th>
 <th>Amenities</th>
 <th>Pricing</th>
 <th>Booking Duration</th>
 <th>Date Available</th>
 <th>State</th>
 <th>ZipCode</th>
 </tr>
  <c:forEach items="${parkinglistcity}" var="plist1">
  <c:forEach items="${zoneitemlistcity}" var="zlist1">
 <tr>
    <td>${zlist1.city}</td>
    <td>${zlist1.zonenumber}</td>
    <td>${plist1.parkinglotid}</td>
    <td>${plist1.parkinglotnum}</td>
    <td>${plist1.availability}</td>
    <td>${zlist1.amenities}</td>
    <td>${plist1.timeslot.pricing}</td>
    <td>${plist1.timeslot.bookinghours}</td>
    <td>${plist1.timeslot.bookingdate}</td>
   <td>${zlist1.state}</td>
   <td>${zlist1.zipcode}</td>
   <td>
<%--                <a href="parkbycityresultsupdate?parkinglotid=${plist1.parkinglotid}&city=${zlist1.city}">Reserve</a> --%>
<!--                 &nbsp; -->
                <a href="parkbycitypay?city=${zlist1.city}&parkinglotid=${plist1.parkinglotid}&parkinglotnumber=${plist1.parkinglotnum}">Reserve&Pay</a>
                &nbsp;
                <a href="parkbycityunreserve?parkinglotid=${plist1.parkinglotid}&city=${zlist1.city}">UNreserve</a>
    </td>
   
 </tr>
  </c:forEach>
  </c:forEach>
  
 </table>
</form>

</body>
</html>