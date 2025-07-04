<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.hero.model.Hero" %>
<%
    List<Hero> list = (List<Hero>) request.getAttribute("dataHero");
%>
<html>
<head>
    <title>Daftar Hero</title>
</head>
<body>
    <h2>Daftar Hero Mobile Legend</h2>
    <a href="hero?action=showForm">[Tambah Hero]</a>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th><th>Nama</th><th>Kategori</th><th>Gender</th><th>Aksi</th>
        </tr>
        <%
            for (Hero h : list) {
        %>
        <tr>
            <td><%= h.getId() %></td>
            <td><%= h.getNama() %></td>
            <td><%= h.getKategori() %></td>
            <td><%= h.getGender() %></td>
            <td>
                <a href="hero?action=edit&id=<%= h.getId() %>">Edit</a>
                |
                <a href="hero?action=delete&id=<%= h.getId() %>" onclick="return confirm('Yakin?')">Hapus</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>