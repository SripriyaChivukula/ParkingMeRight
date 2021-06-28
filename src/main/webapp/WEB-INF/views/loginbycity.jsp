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
<body id="loginpagebodyforcity">
 <div align="center"  id="loginpagedivbycity">
        <h2 id="loginpageh2bycity">Customer Login</h2>
        <form:form action="logincustomerinformationbycity" method="get" modelAttribute="customerkeycity"  >
            <table border="0" cellpadding="5">
            <c:forEach items="${parkinglistcity}" var="plist">
             <c:forEach items="${zoneitemlistcity}" var="zlist">
                <tr>
                    <td>UserName: </td>
                    <td><form:input type="text" id="username" path="username" />
<%--                          <form:errors class="text-danger" path="username" />  --%>
                    </td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:input  id="password" type="password" path="password" />
<%--                      <form:errors class="text-danger" path="password" />  --%>
                    </td>
                </tr>
                <tr>
                 
                    <td>ParkingLot Id: </td>
                    <td>${plist.parkinglotid}
                    <input type="hidden" name="parkinglotid" value="${plist.parkinglotid}" >
                    </td>
                   
                </tr>
                <tr>
                
                    <td>ParkingLot Number: </td>
                    <td>${plist.parkinglotnum}
                    <input type="hidden" name="parkinglotnum" value="${plist.parkinglotnum}" >
                    </td>
                    
                </tr>
                <tr>
                
                    <td>City: </td>
                    <td>${zlist.city}
                    <input type="hidden" name="city" value="${zlist.city}" >      
                    </td>
                    
                </tr>
                 
                <tr>
                
                    <td>ReservationId: </td>
                    <td>${plist.payment.reservationid}
                     <input type="hidden" name="reservationid" value="${plist.payment.reservationid}" >
                    </td>
                    
                </tr>
                
               <tr>
                    <td><input type="submit" value="Login" onclick="return(validateMyForm())"></td>
                </tr>
                 </c:forEach>
                 </c:forEach>                  
            </table>
        </form:form>
        <form action="/parkmeright"><input type="submit" value="Cancel"></form>
    </div>
</body>
</html>