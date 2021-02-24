<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2/24/2021
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="/result" modelAttribute="email" method="post">
    <table>
        <tr>
            <td>Language</td>
            <td><form:select path="language">
                <form:options items="${languageList}"/>
            </form:select></td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show <form:select path="pageSize">
                <form:options items="${sizeList}"/>
            </form:select></td>
        </tr>
        <tr>
            <td>Spam Filter</td>
            <td><form:checkbox path="spamFilter"/>Enable spam filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
           <td>
               <input type="submit" value="Update">
           </td>
        </tr>
    </table>
</form:form>
</body>
</html>
