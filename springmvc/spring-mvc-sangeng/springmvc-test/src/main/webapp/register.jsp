<%--
  Created by IntelliJ IDEA.
  User: xiaohuge
  Date: 2022/6/23
  Time: 10:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
    </title>
</head>
<body>


<form action="${pageContext.request.contextPath}/createUser" method="post" >
  name:<input name="name"/>
  password:<input name="password"/>
  <input type="submit" value="提交"/>
</form>

</body>
</html>
