<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hero.model.Hero" %>
<%
    Hero h = (Hero) request.getAttribute("hero");
    boolean isEdit = (h != null);
%>
<html>
<head>
    <title><%= isEdit ? "Edit" : "Tambah" %> Hero</title>
</head>
<body>
    <h2><%= isEdit ? "Edit" : "Tambah" %> Hero</h2>
    <form action="hero" method="post">
        <input type="hidden" name="action" value="<%= isEdit ? "update" : "insert" %>"/>
        <% if (isEdit) { %>
            <input type="hidden" name="id" value="<%= h.getId() %>"/>
        <% } %>
        Nama: <input type="text" name="nama" value="<%= isEdit ? h.getNama() : "" %>"/><br/>
        Kategori:
        <select name="kategori">
            <%
                String[] kategori = {"MAGE", "ASSASSIN", "FIGHTER", "TANK", "MARKSMAN", "SUPPORT"};
                for (String k : kategori) {
                    String selected = (isEdit && k.equals(h.getKategori())) ? "selected" : "";
            %>
                <option value="<%= k %>" <%= selected %>><%= k %></option>
            <% } %>
        </select><br/>
        Gender:
        <select name="gender">
            <%
                String[] gender = {"MALE", "FEMALE"};
                for (String g : gender) {
                    String selected = (isEdit && g.equals(h.getGender())) ? "selected" : "";
            %>
                <option value="<%= g %>" <%= selected %>><%= g %></option>
            <% } %>
        </select><br/>
        <input type="submit" value="Simpan"/>
    </form>
    <a href="hero">[Kembali ke Daftar]</a>
</body>
</html>