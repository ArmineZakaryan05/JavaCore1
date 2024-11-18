<%@ page import="java.util.List" %>
<%@ page import="org.example.authorbookee.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/14/2024
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>books</title>
</head>
<body>
<h1>Books:</h1>
<% List<Book> books = (List<Book>) request.getAttribute("books");%>
<a href="/addBook">Add Book</a>

<table style="border: 1px solid black">
    <tr>
        <th>id</th>
        <th>title</th>
        <th>price</th>
        <th>quantity</th>
        <th>author name</th>
    </tr>
    <% for (Book book : books) { %>
    <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getQuantity()%></td>
        <td><%=book.getAuthor().getName()%></td>
    </tr>
    <% } %>
</table>
</body>
</html>