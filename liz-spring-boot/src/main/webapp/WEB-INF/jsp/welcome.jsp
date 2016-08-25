<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type= "text/css">
    .daojishi h2
    {
        font-family:Helvetica, Microsoft YaHei, Arial, sans-serif;
        font-size:14px;
        margin-bottom:5px;
        color:#151515;
    }
    .daojishi #timer
    {
        font-family:Helvetica, Microsoft YaHei, Arial, sans-serif;
        font-size:14px;
        color:#151515;
        font-weight:bold;
    }
</style>
<script type="text/javascript">

    function timer(){
        var ts = (new Date(2018, 11, 11, 9, 0, 0)) - (new Date());//计算剩余的毫秒数
        var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);//计算剩余的天数
        var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10);//计算剩余的小时数
        var mm = parseInt(ts / 1000 / 60 % 60, 10);//计算剩余的分钟数
        var ss = parseInt(ts / 1000 % 60, 10);//计算剩余的秒数
        dd = checkTime(dd);
        hh = checkTime(hh);
        mm = checkTime(mm);
        ss = checkTime(ss);
        document.getElementById("timer").innerHTML = dd + "天" + hh + "时" + mm + "分" + ss + "秒";

    }
    function checkTime(i){
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }

    function timeCount(){
        var createTime ="2015-11-23 13:40:41";

        setInterval("timer()",1000);
    }
</script>
<html lang="en">
    <title>Welcome!</title>
<body onload="timeCount()">
    Welcome,You've config your Spring-boot application Supported for JSP!
    <br>
    id : ${id},name :${name}

    <div class = "daojishi">
        <h2>倒计时,剩余时间为：</h2>
        <div id = "timer">
        </div>
    </div>
</body>

</html>