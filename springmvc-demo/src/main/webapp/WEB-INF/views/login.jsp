<%--
  Created by IntelliJ IDEA.
  User: xiaohuge
  Date: 2021-06-05
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> this is login jsp </h1>
<div> ${error} </div>
<form action="/login.do" method="post">
    <input type="text" name="name"/>
    <input type="password" name="password"/>
    <input type="submit" value="提交" />
</form>
</body>
</html>