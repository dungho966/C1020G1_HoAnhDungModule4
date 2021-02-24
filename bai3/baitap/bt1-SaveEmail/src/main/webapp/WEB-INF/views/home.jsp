<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2/24/2021
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>FORM</h1>
<form action="/result">
   <table>
       <tr>
           <td>Languages:</td>
           <td><select name="language" style="width: 500px">
               <option value="english">English</option>
               <option value="vietnamese">Vietnamese</option>
               <option value="japanese">Japanese</option>
               <option value="chinese">Chinese</option>
           </select></td>
       </tr>
       <tr>
           <td>Page Size:</td>
           <td>Show <select name="maximum">
               <option value="5">5</option>
               <option value="10">10</option>
               <option value="15">15</option>
               <option value="25">25</option>
               <option value="50">50</option>
               <option value="100">100</option>
           </select> emails per page</td>
       </tr>
       <tr>
           <td>Spam Filter</td>
           <td><input name="yesno" type="checkbox" value="spam">Enable spams filter</td>
       </tr>
       <tr>
           <td>Signature</td>
           <td><textarea name="signature"></textarea></td>
       </tr>
       <tr>
           <td rowspan="2"><input type="submit" value="Update" style="color: dodgerblue"><input type="submit" value="Cancel"></td>
       </tr>
   </table>


    
</form>
</body>
</html>
