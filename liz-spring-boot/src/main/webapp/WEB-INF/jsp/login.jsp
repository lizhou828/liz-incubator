<%--
  Created by IntelliJ IDEA.
  User: lizhou
  Date: 2015/12/28
  Time: 15:39
  To change this template use File | Settings | Editor | File and Code Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/doLogin" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"/></td>
        </tr>
    </table>
    <input type="submit" value="登陆">
</form>

</body>
</html>
