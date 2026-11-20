
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Old Person</title>
</head>
<body>

    <jsp:useBean id="person"
        type="lab.mvc.model.Person" scope="request" />

    <h2>Person born before 1990</h2>

    <p>First Name:
        <jsp:getProperty name="person" property="firstName"/>
    </p>

    <p>Last Name:
        <jsp:getProperty name="person" property="lastName"/>
    </p>

    <p>Birthday:
        <jsp:getProperty name="person" property="birthDay"/>
    </p>

    <p>Sex:
        <jsp:getProperty name="person" property="sex"/>
    </p>

</body>
</html>
