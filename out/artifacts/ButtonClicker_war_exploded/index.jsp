<%--
  Created by IntelliJ IDEA.
  User: jesse
  Date: 2/12/18
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/WEB-INF/css/index.css" type="text/css">
  </head>
<body>
<form action="/" method="post">
  <input type="submit" value="Click Here!">
</form>



<h1>You have clicked this button <c:out value="${counter}" /></h1>

</body>
</html>
