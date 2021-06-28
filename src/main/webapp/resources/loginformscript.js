
    
    

    function validateMyForm()
    {
     var usernamelength= document.getElementById("username").value;
     var passwordlength = document.getElementById("password").value;
     usernamelength=usernamelength.length;
      passwordlength=passwordlength.length;
     if((usernamelength>=0) && (usernamelength<8))
     {
         console.log(usernamelength);
         
         
         alert("Enter a valid username with minimum 8 characters");
         
         return false;
     }
     else if((passwordlength>=0) &&(passwordlength<8))
     {
         
         alert("Enter a valid password with minimum 8 characters");
         
         return false;
     
     }
     else
     {
       return true;
    }
}
     
    
    