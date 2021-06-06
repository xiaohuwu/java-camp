<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <title>Todos for <c:out value="${sessionScope.name}"/>   </title>
</head>
<body>

<H1>Your Todos ${sessionScope.name}</H1>
${todos}
</body>
</html>