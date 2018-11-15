<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.shaulayh.utils.Mappings" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
<div align="center">
    <c:url var="addItem" value="${Mappings.ADD_ITEM}"/>
    <a href="${addItem}">Add Item</a>
    <h1>Items</h1>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Details</th>
            <th>Deadline</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="item" items="${todoData.items}">
            <c:url var="editUrl" value="${Mappings.ADD_ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <c:url var="deleteUrl" value="${Mappings.DELETE}">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <c:url var="itemUrl" value="${Mappings.ITEM}">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${item.title}"/></td>
                <td><c:out value="${item.details}"/></td>
                <td><c:out value="${item.deadline}"/></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${itemUrl}">View</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>