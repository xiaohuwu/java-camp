<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>

<script>
    function del(id) {
        if (confirm("是否删除用户？")) {
            window.location = "${pageContext.request.contextPath}/user/delete?id=" + id;
        }
    }

    function delSelected() {
        var selectedIds = [];
        $(".userCheckbox:checked").each(function () {
            selectedIds.push($(this).val());
        });
        if (selectedIds.length === 0) {
            alert("请选择要删除的用户。");
            return;
        }
        if (confirm("是否删除选中的用户？")) {
            $.post("${pageContext.request.contextPath}/user/batchDelete", {ids: selectedIds}, function (data) {
                alert(data)
            });
        }
    }

    function updateSelected() {
        $.ajax({
            url: '${pageContext.request.contextPath}/user/batchUpdate',
            type: 'post',
            data: JSON.stringify({
                users: [
                    {username: 'zhangsan', name: '张三'},
                    {username: 'lisi', name: '李四'},
                    {username: 'wangwu', name: '王五'}
                ]
            }),
            contentType: 'application/json',
            success: function (data) {
                alert("修改成功！");
            }
        });
    }

</script>

<body>
<h3>用户列表</h3>
<div>
    <form id="query-form" method="get" action="${pageContext.request.contextPath}/user/list">
        <label>用户名：</label>
        <input type="text" name="username" value="">
        <input type="submit" value="查询">
    </form>
    <button onclick="delSelected()">批量删除</button>
    <button onclick="updateSelected()">批量修改</button>
</div>
<table id="dept-table" border="1">
    <thead>
    <tr>
        <th width="20px"></th>
        <th width="320px">id</th>
        <th width="150px">用户名</th>
        <th width="100px">姓名</th>
        <th width="150px">生日</th>
        <th width="150px">头像</th>
        <th width="150px">所属部门</th>
        <th width="100px">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${userList != null}">
        <c:forEach items="${userList}" var="user">
            <tr>
                <td><input type="checkbox" class="userCheckbox" value="${user.id}"></td>
                <td align="center">${user.id}</td>
                <td align="center">${user.username}</td>
                <td align="center">${user.name}</td>
                <td align="center">${user.birthday}</td>
                <td align="center"><img style="width: 100px;height: auto;"
                                        src="${pageContext.request.contextPath}/user/getPhoto?id=${user.id}"></td>
                <td align="center">${user.department.name}</td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">编辑</a>
                    <a href="javascript:del('${user.id}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
