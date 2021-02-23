<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2/23/2021
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose Condiment</title>
</head>
<body>
<form action="/result">
    <h1>Sandwich Condiment</h1>
    <hr>
    <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
    <input type="checkbox" name="condiment" value="Tomato"> Tomato
    <input type="checkbox" name="condiment" value="Mustard"> Mustard
    <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
    <br>
    <br>
    <input type="submit" value="Add">
</form>
</body>
</html>
