<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name=referrer content=never>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="renderer" content="webkit">
</head>
<body>


一、在html内 使用iframe在线预览doc文件
<iframe src="http://localhost:8080/docs/51job_陈沙_财务出纳(259119776).pdf" width="400" height="500"></iframe>

<br>
<br>
<br>
二、打开新页面预览PDF
<button onclick="preview()">PDF预览</button>

</body>
<script>
    function preview() {
        console.log('test');
        var pdf = 'https://axhl-test-1252661357.cos.ap-shanghai.myqcloud.com/pdf/1536742627489-310270d9-4e12-2640-8cb6-cfc07a6f6d1b.pdf'; //远程服务器的文件url
        pdf = 'http://localhost:8080/docs/51job_陈沙_财务出纳(259119776).pdf'; //本服务器上的文件url
        pdf = '/docs/51job_陈沙_财务出纳(259119776).pdf'; //服务器上的文件目录
        pdf = encodeURI('/docs/51job_陈沙_财务出纳(259119776).pdf'); //encodeURI()可以防止IE浏览器的400 bad request问题
        window.open('./js/pdf/web/viewer.html?file=' + pdf, 'PDF');
    }
</script>
</html>