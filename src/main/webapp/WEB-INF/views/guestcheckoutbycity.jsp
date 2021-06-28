<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest</title>
<link rel=stylesheet href="resources/home.css" type="text/css">
</head>
<body id="guestcheckoutbycity">

    <div align="center">
        <h2>Guest Checkout</h2>
        <form:form action="recieptguestformbycity" method="GET" modeAttribute="customerkey">
            <table border="0" cellpadding="5">
            
            <c:forEach items="${parkinglistcity}" var="plist"> 
            <c:forEach items="${zoneitemlistcity}" var="zlist"> 
                <tr>
                    <td>Parkinglot ID: </td>
                    
                    <td> 
                       ${plist.parkinglotid}
                     <input type="hidden" name="parkinglotid" value="${plist.parkinglotid}" >
                        </td> 
                   
                </tr>
                <tr>
                    <td>Zone Number: </td>
                    
                    <td> 
                       ${zlist.city}
                     <input type="hidden" name="city" value="${zlist.city}" >
                        </td> 
                   
                </tr>
                <tr>
                    <td>Reservation ID: </td>
                    
                    <td> 
                       ${plist.payment.reservationid}
                     <input type="hidden" name="reservationid" value="${plist.payment.reservationid}" >
                        </td> 
                   
                </tr>
                   
                </c:forEach> 
                </c:forEach> 
                <tr>
                    <td>FirstName: </td>
                    <td><input type="text" name="firstname"/>
                         
                    </td>
                </tr>
                <tr>
                    <td>LastName: </td>
                    <td><input type="text" name="lastname"/>
                        
                    </td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address"/>
                         
                    </td>
                </tr>   
                <tr>
                    <td>EMail: </td>
                    <td><input type="text" name="email"/>
                     
                    </td>
                </tr>    
                <tr>
                    <td>Phone: </td>
                    <td><input type="text" name="phonenum"/>
                        
                    </td>
                </tr>    
               
               <tr>
              <td> <input type="submit" value="payment">
                   
              </td>
               </tr>
                                 
            </table>
        </form:form>
        <form action="/parkmeright"><input type="submit" value="Cancel"></form>
    </div>


</body>
</html>