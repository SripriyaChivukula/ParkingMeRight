<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payments</title>
</head>
<body>
    <div align="center">
        <h2>Payments</h2>
        <form:form>
            <table border="0" cellpadding="5">
            <c:forEach items="${parkinglistcity}" var="plist1">
            <c:forEach items="${zoneitemlistcity}" var="zlist1">
                <tr>
                    <td>Zone Number: </td>
                    <td>${zlist1.zonenumber}
                        <form:hidden path="zonenumber"/>
                    </td>
                </tr>  
                <tr>     
                 <td>ParkingLot ID: </td>
                    <td>${plist1.parkinglotid}
                        <form:hidden path="parkinglotid"/>
                    </td>
                    </tr>
                    <tr>
                     <td>ParkingLot Number: </td>
                    <td>${plist1.parkinglotnum}
                        <form:hidden path="parkinglotnum"/>
                    </td>
                    </tr>
                    <tr>
                     <td>Booking Date: </td>
                    <td>${plist1.timeslot.bookingdate}
                        <form:hidden path="bookingdate"/>
                    </td>  
                    </tr>
                    <tr>
                     <td>Booking Hours: </td>
                    <td>${plist1.timeslot.bookinghours}
                        <form:hidden path="bookinghours"/>
                    </td> 
                    </tr>
                    <tr> 
                    <td>Price: </td>
                    <td>${plist1.timeslot.pricing}
                        <form:hidden path="pricing"/>
                    </td> 
                    </tr>
                    <tr> 
                    <td>Reservation ID: </td>
                    <td>${plist1.payment.reservationid}
                        <form:hidden path="reservationid"/>
                    </td> 
                    </tr>
                    <tr> 
                    <td>Tax: </td>
                    <td>${plist1.payment.tax}
                        <form:hidden path="tax"/>
                    </td> 
                    </tr>
                    <tr> 
                    <td>Total: </td>
                    <td>${plist1.payment.total}
                        <form:hidden path="total"/>
                    </td> 
                    </tr>
                     
                    
                
                    <td colspan="2"><input type="submit" value="Pay"></td>
                </tr> 
                </c:forEach>
                </c:forEach>                   
            </table>
        </form:form>
    </div>
</body>
</html>