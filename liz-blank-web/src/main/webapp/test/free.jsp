<%@ page import="com.liz.blankWeb.test.TestMain" %>
<%--
  Created by IntelliJ IDEA.
  User: lizhou
  Date: 2016/8/11
  Time: 14:55
  To change this template use File | Settings | Editor | File and Code Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        TestMain.list.clear();
        TestMain.counter = 0;
    %>
    Free collection OK!<br/>
    SIZE:<%=TestMain.list.size()%><br/>
    counter:<%=TestMain.counter++%><br/>

</body>
</html>
