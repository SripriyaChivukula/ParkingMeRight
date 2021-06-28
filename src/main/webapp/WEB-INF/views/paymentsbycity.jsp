<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payments</title>
<link rel=stylesheet href="resources/home.css" type="text/css">
</head>
<body id="paymentspagebody">
    <div align="center">
       
      <form:form  method="get" modelAttribute="parkinglotkey"> 
      <h1>Customer Payment Receipt</h1>
            <table border="0" cellpadding="5">
           <c:forEach items="${parkinglistcity}" var="plist">
           <c:forEach items="${zoneitemlistcity}" var="zlist">
           
           
           <tr>
                   <td>Zone Number:</td>    
                    <td>${zlist.zonenumber}
                    </td>
                </tr> 
                <tr>
                   
                   <td>ParkingLot ID:</td>
                    <td>${plist.parkinglotid}
                     </td>
                </tr> 
                
                <tr>
                   <td>ParkingLot Number:</td>    
                    <td>${plist.parkinglotnum}
                    </td>
                </tr> 
                
                 <tr>
                   <td>Reservation Number:</td>    
                    <td>${plist.payment.reservationid}
                    </td>
                </tr> 
                 <tr>
                   <td>Booking hours:</td>    
                    <td>${plist.timeslot.bookinghours}
                    </td>
                </tr> 
                <tr>
                   <td>Booking Date:</td>    
                    <td>${plist.timeslot.bookingdate}
                    </td>
                </tr> 
                 <tr>
                   <td>Price Before Tax :</td>    
                    <td>${plist.timeslot.pricing}
                    </td>
                </tr> 
                 <tr>
                   <td>Tax :</td>    
                    <td>${plist.payment.tax}
                    </td>
                </tr> 
                 <tr>
                   <td>Total :</td>    
                    <td>${plist.payment.total}
                    </td>
                </tr> 
                
                <tr>
                     <td>First Name:</td>
                    <td>${plist.customer.firstname}</td>

                </tr>
                    <tr><td>Last Name:</td>
                    <td>${plist.customer.lastname}</td>

                </tr>
                
                <tr>
                      <td>Address:</td>
                    <td>${plist.customer.address}</td>

                </tr>   
                <tr>
                     <td>Email:</td>
                    <td>${plist.customer.email}</td>

                </tr>    
                <tr>
                       <td>Phone Number:</td>
                    <td>${plist.customer.phonenum}</td>

                </tr>    
               
                   
               
                
               </c:forEach>
               </c:forEach>     
                          
            </table>
        </form:form>
        <form action="./parkmeright"><input type="submit" value="Home"></form>
    </div>
    
</body>
</html>