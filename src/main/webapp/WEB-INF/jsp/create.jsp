<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.05.2020
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="margin-left: 13%">
<h1>Форма создания курса</h1>
<form method="post" action="/course/save">
    <input placeholder="name" name="name" type="text" required>
    <input placeholder="duration" required name="duration" type="number">
    <button type="submit">Создать</button>
</form>

<p></p>

<form action="/uploadFile" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="text" name="name"/>
    <button type="submit">Загрузить файл</button>
</form>
<p style="color: red">${success}</p>

</body>
</html>
