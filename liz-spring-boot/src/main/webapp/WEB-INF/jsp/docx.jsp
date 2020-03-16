<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
在线预览doc文件

<iframe id="iframeDoc" src="" width="600" height="500"></iframe>
</body>
<script type="text/javascript">
    //    var url = "https://view.officeapps.live.com/op/view.aspx?src='http://localhost:8080/docs/组织发展高级经理-猎聘网简历.doc'";
    var url = "https://view.officeapps.live.com/op/view.aspx?src=newteach.pbworks.com%2Ff%2Fele%2Bnewsletter.docx";
    url = "https://view.officeapps.live.com/op/view.aspx?src=http://storage.xuetangx.com/public_assets/xuetangx/PDF/1.xls";
    document.getElementById("iframeDoc").src = url;
</script>
</html>
