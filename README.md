1) Open the project in IntelliJ
2) expand all the modules 
3)run the eureka server first, api gateway second, userauth third,user service fourth, book last
4)open the postman ang give the http request in select post http://localhost:8090/api/auth/save to save the user details.
   format
  {
    "userid":"1",
    "username":"balaji",
    "password":"balaji123",
    "email":"shree123@gmail.com"
}

login - http://localhost:8090/api/auth/login
 
{
   
    "username":"balaji",
    "password":"balaji123"
    
}

book - http://localhost:8092/api/Books

