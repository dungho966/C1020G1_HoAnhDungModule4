<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2/23/2021
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculation</title>
</head>
<body>
<form action="/result">
    <h2>Simple Calculator</h2>
    <input type="number" name="number1">
    <select name="cal">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="text" name="number2">
    <input type="submit" value="=">

</form>
<h4>Result is: ${res}</h4>
</body>
</html>
