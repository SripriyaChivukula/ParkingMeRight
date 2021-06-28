<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="resources/home.css" type="text/css">
<title>Login customer Info</title>
</head>
<body id="logincustomerinfobody">
<div align="center">
        <h2>Customer login Information</h2>
      <form:form action="recieptform"  method="get" > 
    
            <table border="0" cellpadding="5">
           <c:forEach items="${parkinglist}" var="plist">
           <c:forEach items="${zoneitemlist}" var="zlist">
           
           
           <tr>
                   <td>Zone Number:</td>    
                    <td>${zlist.zonenumber}
                    <input type="hidden" name="zonenumber" value="${zlist.zonenumber}" >
                    </td>
                </tr> 
                <tr>
                   
                   <td>ParkingLot ID:</td>
                    <td>${plist.parkinglotid}
                     <input type="hidden" name="parkinglotid" value="${plist.parkinglotid}" >
                     </td>
                </tr> 
                
                <tr>
                   <td>ParkingLot Number:</td>    
                    <td>${plist.parkinglotnum}
                    <input type="hidden" name="parkinglotnum" value="${plist.parkinglotnum}" >
                    </td>
                </tr> 
                
                 <tr>
                   <td>Reservation Number:</td>    
                    <td>${plist.payment.reservationid}
                    <input type="hidden" name="reservationid" value="${plist.payment.reservationid}" >
                    </td>
                </tr> 
                 <tr>
                   <td>Booking hours:</td>    
                    <td>${plist.timeslot.bookinghours}
                    <input type="hidden" name="bookinghours" value="${plist.timeslot.bookinghours}" >
                    </td>
                </tr> 
                <tr>
                   <td>Booking Date:</td>    
                    <td>${plist.timeslot.bookingdate}
                    <input type="hidden" name="bookingdate" value="${plist.timeslot.bookingdate}" >
                    </td>
                </tr> 
                 <tr>
                   <td>Price Before Tax :</td>    
                    <td>${plist.timeslot.pricing}
                    <input type="hidden" name="pricing" value="${plist.timeslot.pricing}" >
                    </td>
                </tr> 
                 <tr>
                   <td>Tax :</td>    
                    <td>${plist.payment.tax}
                    <input type="hidden" name="tax" value="${plist.payment.tax}" >
                    </td>
                </tr> 
                 <tr>
                   <td>Total :</td>    
                    <td>${plist.payment.total}
                    <input type="hidden" name="total" value="${plist.payment.total}" >
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
                <tr>
                    
                    
                 <td> <input type="hidden" name="username" value="${plist.customer.username}" ></td>
                   

                </tr>    
                <tr>
                   
                    
                <td> <input type="hidden" name="password" value="${plist.customer.password}" ></td>
                   

                </tr>        
                 <tr>
                 <td><input type="submit" value="Payment"></td>
               
              </tr>  
               </c:forEach>
               </c:forEach>     
                    
                          
            </table>
        </form:form>
        <form action="/parkmeright"><input type="submit" value="Cancel"></form>
        
    </div>

</body>
</html>