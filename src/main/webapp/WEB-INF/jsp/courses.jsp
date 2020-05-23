<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.05.2020
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous"></script>
</head>
<body>
<h1>${courses}</h1>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            type: "POST",
            url: "/courses/add",
            contentType: "application/json",
            data: JSON.stringify({name: "spring web", duration: "48"})
            dataType: "json"
        })
    })
</script>

</body>
</html>
