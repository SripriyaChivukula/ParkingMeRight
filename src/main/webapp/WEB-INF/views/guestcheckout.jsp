<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="resources/home.css" type="text/css">
<title>Guest</title>
</head>
<body id="guestcheckoutpage">

    <div align="center">
        <h2>Guest Checkout</h2>
        <form:form action="recieptguestform" method="GET" modelAttribute="customerkey">
            <table border="0" cellpadding="5">
            
            <c:forEach items="${parkinglist}" var="plist"> 
            <c:forEach items="${zoneitemlist}" var="zlist"> 
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
                       ${zlist.zonenumber}
                     <input type="hidden" name="zonenumber" value="${zlist.zonenumber}" >
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
                    <td><form:input type="text" path="firstname"/></td>
                        <form:errors  path="firstname"/></td>
                </tr>
                <tr>
                    <td>LastName: </td>
                    <td><form:input type="text" path="lastname"/></td>
                        <form:errors  path="lastname"/></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><form:input type="text" path="address"/></td>
                        <form:errors  path="address"/>
                </tr>   
                <tr>
                    <td>EMail: </td>
                    <td><form:input type="text" path="email"/>
                          <form:errors  path="email"/>
                          </td>
                </tr>    
                <tr>
                    <td>Phone: </td>
                    <td><input type="text" name="phonenum"/>
                          
                    </td>
                    
                    
                </tr>    
               
               <tr>
              <td> <input type="submit" value="Payment"></td>
               </tr>
                                 
            </table>
        </form:form>
        <form action="/parkmeright"><input type="submit" value="Cancel"></form>
    </div>


</body>
</html>