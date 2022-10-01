1. start application
> just run App.java

2. How to test API
  open the browser, and input the follow example url
   - create user
   > http://localhost:9000/user/create?username=test&passowrd=123
   - delete user
   > http://localhost:9000/user/delete?username=test
   - add role to user
   > http://localhost:9000/user/roleAdd?username=test&roleName=role1
   - authenticate
   > http://localhost:9000/user/authenticate?username=test&passowrd=123
   - invalidate
   > http://localhost:9000/user/invalidate?token=abc
   - get all user roles
   > http://localhost:9000/user/roleCheck?token=abc&roleName=role1
   - check user role
   > http://localhost:9000/user/roles?token=abc
   - create role
   > http://localhost:9000/role/add?roleName=role1
   - delete role
   > http://localhost:9000/role/delete?roleName=role1

   
3. PS：
   - import jetty for web server