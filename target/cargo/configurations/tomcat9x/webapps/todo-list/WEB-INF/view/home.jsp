<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.shaulayh.utils.Mappings" %>
<html>
<head>
    <title>Item list</title>
</head>
<body>
<div align="center">
    <c:url var="itemLink" value="${Mappings.ITEMS}"/>
    <h2><a href="${itemLink}">Show Items</a></h2>
</div>
</body>
</html>