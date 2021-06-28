<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page session="true" buffer="8kb" errorPage="errorpage.jsp" import="java.util.Date" %>
<link rel=stylesheet href="resources/home.css" type="text/css">
<title>Customer Registration</title>
</head>


	<body id="customerregistration">
    <div align="center">
        <h2>Customer Registration</h2>
        <form:form action="customerinformationform" method="POST" modelAttribute="customerkey">
            <table border="0" cellpadding="5">
                <tr>
                    <td>FirstName: </td>
                    <td><form:input type="text" path="firstname" />
                        <form:errors class="text-danger" path="firstname" /> 
                    </td>
                    
                </tr>
                <tr>
                    <td>LastName: </td>
                    <td><form:input type="text"  path="lastname" />
                     <form:errors class="text-danger" path="lastname" /> 
                    </td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><form:input type="text" path="address" />
                   <form:errors class="text-danger" path="address" /> 
                    </td>
                </tr>   
                <tr>
                    <td>EMail: </td>
                    <td><form:input type="text" path="email" />
                   <form:errors class="text-danger" path="email" /> 
                    </td>
                </tr>    
                <tr>
                    <td>Phone: </td>
                    <td><form:input type="text" path="phonenum" />
                     <form:errors class="text-danger" path="phonenum" /> 
                    </td>
                </tr>    
                <tr>
                    <td>UserName: </td>
                    <td><form:input type="text" path="username" />
                         <form:errors class="text-danger" path="username" />
                    </td>
                </tr>    
                <tr>
                    <td>Password: </td>
                    <td><form:input type="password" path="password" />
                   <form:errors class="text-danger" path="password" />
                    </td>
                </tr>    
                <tr>
                    <td>RewardPoints: </td>
                    <td><form:input type="text" path="rewardpoints" />
                         <form:errors class="text-danger" path="rewardpoints" /> 
                    </td>
                </tr> 
                         
                <tr>
                    <td colspan="2"><input type="submit" value="Register">
                    
                    </td>
                </tr>                    
            </table>
        </form:form>
        <form action="/parkmeright"><input type="submit" value="Cancel"></form>
    </div>
</body>
 
	
	
	

</html>