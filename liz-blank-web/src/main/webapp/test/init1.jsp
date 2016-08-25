<%@ page import="com.liz.blankWeb.test.TestBean" %>
<%@ page import="com.liz.blankWeb.test.TestMain" %><%--
  Created by IntelliJ IDEA.
  User: lizhou
  Date: 2016/8/10
  Time: 17:31
  To change this template use File | Settings | Editor | File and Code Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>init1</title>
</head>
<body>
<%
    TestBean b = null;
    for(int i=0;i<10000;i++){
        b = new TestBean();
        TestMain.list.add(b);
    }
%>
SIZE:<%=TestMain.list.size()%><br/>
counter:<%=TestMain.counter++%>
</body>
</html>
