<%--
  Created by IntelliJ IDEA.
  User: xioahuge
  Date: 2023/4/23
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Hello World - JSP
    </title>
</head>
<body>

<%-- JSP Comment --%>
<h1>Hello World!</h1>
<p>
    <%
        out.println("Your IP address is ");
    %>
    <span style="color:red">
        <%= request.getRemoteAddr() %>
    </span>
</p>

</body>
</html>
