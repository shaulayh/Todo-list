<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.shaulayh.utils.AttributeNames" %>
<%@ page import="com.shaulayh.utils.Mappings" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
<h1>Welcome page</h1>
<div align="center">
    <h1>View of todo number ${Id}</h1>
    <p>${Id}</p>
    <p>${title}</p>
    <p>${details}</p>
    <p>${deadline}</p>
    <c:url var="itemLink" value="${Mappings.ITEMS}"/>
    <h2><a href="${itemLink}">Show Items</a></h2>
</div>
<%--<div modelAttribute="${AttributeNames.TODO_ITEM}">--%>
<%--<p path="Id"></p>--%>
<%--<p>${title}</p>--%>
<%--<p>${details}</p>--%>
<%--<p>${deadline}</p>--%>
<%--</div>--%>
</body>
</html>