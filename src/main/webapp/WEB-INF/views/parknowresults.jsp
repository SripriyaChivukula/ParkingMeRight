<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose From Available ParkingLots</title>
<link rel=stylesheet href="resources/home.css" type="text/css">
</head>
<body id="parknowresultsbody">
<h1 id="paknowresultspageh1">ParkNow Results</h1>
<form >
<div id="parknowresultspagediv"  style="overflow-x:auto;">
 <table border="1" cellpadding="5" id="parknowresultspagetable">
 <tr id="parknowresultspagetr">
 <th id="parknowresultspageth">ZoneNumber</th>
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
  <c:forEach items="${parkinglist}" var="plist">
  <c:forEach items="${zoneitemlist}" var="zlist">
 <tr>
    <td id="parknowresultspagetd">${zlist.zonenumber}</td>
    <td>${plist.parkinglotid}</td>
    <td>${plist.parkinglotnum}</td>
    <td>${plist.availability}</td>
    <td>${zlist.amenities}</td>
    <td>${plist.timeslot.pricing}</td>
    <td>${plist.timeslot.bookinghours}</td>
    <td>${plist.timeslot.bookingdate}</td>
   <td>${zlist.state}</td>
   <td>${zlist.zipcode}</td>
   <td>
<%--                 <a href="parknowresultsupdate?parkinglotid=${plist.parkinglotid}&zonenumber=${zlist.zonenumber}">Reserve</a> --%>
<!--                 &nbsp; -->
                <a href="parknowpayments?zonenumber=${zlist.zonenumber}&parkinglotid=${plist.parkinglotid}&parkinglotnumber=${plist.parkinglotnum}">Reserve&Pay</a>
                &nbsp;
                <a href="parknowunreserve?parkinglotid=${plist.parkinglotid}&zonenumber=${zlist.zonenumber}">UNreserve</a>
    </td>
   
 </tr>
  </c:forEach>
  </c:forEach>
 
 </table>
  </div>
</form>
</body>
</html>