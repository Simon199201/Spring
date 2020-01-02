<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/12/31
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form style="flex-direction: column" action="${pageContext.request.contextPath}/quick22" method="post" enctype="multipart/form-data">
    姓名<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile"><br/>
    文件<input type="file" name="uploadFile2"><br/>
    <input type="submit" value="提交">

</form>

<form style="flex-direction: column" action="${pageContext.request.contextPath}/quick23" method="post" enctype="multipart/form-data">
    姓名<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile"><br/>
    文件<input type="file" name="uploadFile"><br/>
    <input type="submit" value="提交">

</form>
</body>
</html>
