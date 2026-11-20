<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scriptlet JSP</title>
</head>
<body>

    <%
        java.util.Date date = new java.util.Date();
        String host = request.getRemoteHost();
    %>

    <h2>Current time:</h2>
    <p><%= date %></p>

    <h2>Remote host:</h2>
    <p><%= host %></p>

</body>
</html>
