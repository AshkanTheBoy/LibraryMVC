<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <h2>Library Table</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Stock</th>
                <th>Section</th>
                <th>
                    <a href="/app/create">Create</a>
                </th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.name}</td>  
                    <td>${book.stock}</td>  
                    <td>${book.section}</td>  
                    <td>
                        <a href="/app/edit/${book.id}">Edit</a>
                        <a href="/app/delete/${book.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
