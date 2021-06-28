<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page session="true" buffer="8kb" errorPage="errorpage.jsp" import="java.util.Date" %>
<link rel=stylesheet href="resources/home.css" type="text/css">
<script src="resources/loginformscript.js" type="text/javascript" ></script>
<title>Login</title>
</head>
<body id="loginpagebody">
 <div align="center"  id="loginpagediv">
        <h2 id="loginpageh2">Customer Login</h2>
        
        <form:form action="logincustomerinformation" method="get" modelAttribute="customerkey"  >
            <table border="0" cellpadding="5">
            <c:forEach items="${parkinglist}" var="plist">
             <c:forEach items="${zoneitemlist}" var="zlist">
                <tr>
                    <td class="labeltable">UserName: </td>
                    <td><form:input type="text" id="username" path="username" />
<%--                   <form:errors class="text-danger" path="username" />  --%>
                    </td>
                </tr>
                <tr>
                    <td class="labeltable">Password: </td>
                    <td><form:input  id="password" type="password" path="password" />
<%--                      <form:errors class="text-danger" path="password" />  --%>
                    </td>
                </tr>
                <tr>
                 
                    <td class="labeltable">ParkingLot Id: </td>
                    <td class="labeltable">${plist.parkinglotid}
                    <input type="hidden" name="parkinglotid" value="${plist.parkinglotid}" >
                    </td>
                   
                </tr>
                <tr>
                
                    <td class="labeltable">ParkingLot Number: </td>
                    <td class="labeltable">${plist.parkinglotnum}
                    <input type="hidden" name="parkinglotnum" value="${plist.parkinglotnum}" >
                    </td>
                    
                </tr>
                <tr>
                
                    <td class="labeltable">Zone Number: </td>
                    <td class="labeltable">${zlist.zonenumber}
                    <input type="hidden" name="zonenumber" value="${zlist.zonenumber}" >      
                    </td>
                    
                </tr>
                 
                <tr>
                
                    <td class="labeltable">ReservationId: </td>
                    <td class="labeltable">${plist.payment.reservationid}
                     <input type="hidden" name="reservationid" value="${plist.payment.reservationid}" >
                    </td>
                    
                </tr>
                
               <tr>
                    <td class="labeltable"><input type="submit" value="Login" onclick="return(validateMyForm())"></td>
                </tr>
                 </c:forEach>
                 </c:forEach>                  
            </table>
        </form:form>
        <form action="/parkmeright"><input type="submit" value="Cancel"></form>
    </div>
</body>
</html>