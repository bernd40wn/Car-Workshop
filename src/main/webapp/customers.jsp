<%--
  Created by IntelliJ IDEA.
  User: migiel
  Date: 13.08.18
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="WEB-INF/includes/header.jspf" %>

<h2>Klienci</h2>


<h3>Lista wszystkich klientów</h3>


<h3>Dodaj nowego klienta</h3>
<form action="" method="post">
    <p><label>Imię: <input type="text" name="name" /></label></p>
    <p><label>Nazwisko: <input type="text" name="surname" /></label></p>
    <p><label>Adres: <input type="text" name="address" /></label></p>
    <p><label>Telefon: <input type="text" name="phone" /></label></p>
    <p><label>Data urodzenia: <input type="text" name="birthdate" /></label></p>
    <p><input type="submit" value="Dodaj klienta" /></p>

<ul>
    <li><a href="/customer/add">Dodaj nowego klienta</a></li>
    <li><a href="/customer/edit">Edytuj klienta</a></li>
</ul>

<h3>Lista wszystkich klientów</h3>

<ul>
    <li><a href="/customer/add">Dodaj nowego klienta</a></li>
    <li><a href="/customer/edit">Edytuj klienta</a></li>
</ul>

</body>
</html>
