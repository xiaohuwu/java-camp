<%--
  Created by IntelliJ IDEA.
  User: joony
  Date: 2022/10/25
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/login" enctype="multipart/form-data">
  用户名：<input type="text" name="userName">
  密码：<input type="password" name="password">
   头像： <input type="file" name ="portrait">
  <input type="submit">
</form>

</body>
</html>
