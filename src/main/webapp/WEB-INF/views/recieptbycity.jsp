<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel=stylesheet href="resources/home.css" type="text/css">
</head>
<body id="guestbycity">
<h1>Thank you for the payment..You will recieve a confirmation email shortly</h1>
    <div align="center">
        <h2>Parking Receipt</h2>
        <form:form>
            <table border="0" cellpadding="5">
            <c:forEach items="${parkinglist}" var="plist">
            <c:forEach items="${zoneitemlist}" var="zlist">
                 <tr>
                    <td>First Name: </td>
                    <td>${plist.customer.firstname}
                       
                    </td>
                </tr> 
                <tr>
                    <td>Last Name: </td>
                    <td>${plist.customer.lastname}
                       
                    </td>
                </tr>  
                <tr>
                    <td>Email: </td>
                    <td>${plist.customer.email}
                       
                    </td>
                </tr>  
                <tr>
                    <td>Phone: </td>
                    <td>${plist.customer.phonenum}
                        
                    </td>
                </tr>   
                <tr>
                    <td>Zone Number: </td>
                    <td>${zlist.city}
                       
                    </td>
                </tr>  
                <tr>     
                 <td>ParkingLot ID: </td>
                    <td>${plist.parkinglotid}
                       
                    </td>
                    </tr>
                    <tr>
                     <td>ParkingLot Number: </td>
                    <td>${plist.parkinglotnum}
                       
                    </td>
                    </tr>
                    <tr>
                     <td>Booking Date: </td>
                    <td>${plist.timeslot.bookingdate}
                        
                    </td>  
                    </tr>
                    <tr>
                     <td>Booking Hours: </td>
                    <td>${plist.timeslot.bookinghours}
                        
                    </td> 
                    </tr>
                    <tr> 
                    <td>Price: </td>
                    <td>${plist.timeslot.pricing}
                        
                    </td> 
                    </tr>
                    <tr> 
                    <td>Reservation ID: </td>
                    <td>${plist.payment.reservationid}
                        
                    </td> 
                    </tr>
                    
                    <tr> 
                    <td>Total: </td>
                    <td>${plist.payment.total}
                        
                    </td> 
                    </tr>
                     
                  <tr>  
                
                    
                </tr> 
                </c:forEach>
                </c:forEach>                   
            </table>
        </form:form>
         <form action="./parkmeright"><input type="submit" value="Home"></form>
    </div>


</body>
</html>