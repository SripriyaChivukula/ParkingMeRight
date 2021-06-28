<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel=stylesheet href="resources/home.css" type="text/css">
<title>Customer Information</title>
</head>


	<body id="customerinformationpage">
    <div align="center">
        <h2>Customer Information</h2>
        <form:form modelAttribute="customerkey" action="delete" method="get">
            <table border="0" cellpadding="5">
             
                <tr>
                    <td>FirstName: </td>
                    <td>${customerkey.firstname}
                    <form:hidden  path="firstname" />
                        
                    </td>
                    
                </tr>
                <tr>
                    <td>LastName: </td>
                    <td>${customerkey.lastname}
                    <form:hidden   path="lastname" />
                    
                    </td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td>${customerkey.address}
                    <form:hidden  path="address" />
                  
                    </td>
                </tr>   
                <tr>
                    <td>EMail: </td>
                    <td>${customerkey.email}
                    <form:hidden  path="email" />
                   
                    </td>
                </tr>    
                <tr>
                    <td>Phone: </td>
                    <td>${customerkey.phonenum}
                    <form:hidden  path="phonenum" />
                    
                    </td>
                    
                </tr>
                <tr>
               
                    <td>UserName: </td>
                    <td>${customerkey.username}
                    <form:hidden path="username" />
                    
                    </td>
                    
                </tr>
                <tr>
               
                   
                    <td>${customerkey.password}
                    <form:hidden path="password" />
                    
                    </td>
                    
                </tr>
                <tr>
                    <td>RewardPoints: </td>
                    <td>${customerkey.rewardpoints}
                    <form:hidden  path="rewardpoints" />
                         
                    </td>
                </tr> 
                <tr>
                   <td><input type="submit" value="Unsubscribe"></td>
                   </tr>
                             
            </table>
        </form:form>
       
         <form action="/parkmeright"><input type="submit" value="Cancel"></form>
    </div>
</body>
 
	
	
	

</html>