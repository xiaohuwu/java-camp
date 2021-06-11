<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> this is login jsp </h1>
<form action="/user/add" method="post">
    <input type="text" name="name"/>
    <input type="password" name="password"/>
    <input type="submit" value="提交" />
</form>
</body>
</html>