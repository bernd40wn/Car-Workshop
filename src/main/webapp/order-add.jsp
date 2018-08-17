<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hotshot
  Date: 14.08.18
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<%@ include file="WEB-INF/includes/header.jspf" %>

<body id="page-top">

<%@ include file="WEB-INF/includes/navbar.jspf" %>

<div id="wrapper">

    <%@ include file="WEB-INF/includes/sidebar.jspf" %>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="/home">Strona główna</a>
                </li>
                <li class="breadcrumb-item">
                    <a href="/orders">Zlecenia</a>
                </li>
                <li class="breadcrumb-item active">Dodaj nowe zlecenie</li>
            </ol>

            <h2>Dodaj nowe zlecenie</h2>

            <form action="" method="post">
                <p><label>Data przyjecia: <input type="date" name="admissionDate"/></label></p>
                <p><label>Data planowanego serwisu: <input type="date" name="plannedServiceDate"/></label></p>
                <p><label>Data serwisu: <input type="date" name="serviceDate"/></label></p>
                <p><label>Wybierz pracownika
                    <select name="employee_id">
                        <c:forEach var="employee" items="${employees}">
                            <option value="${employee.id}">${employee.name} ${employee.surname}</option>
                        </c:forEach>
                    </select>
                </label></p>
                <p><label>Opis problemu:
                    <textarea name="carProblemDescription" rows="4" cols="50"></textarea>
                </label></p>
                <p><label>Opis naprawy:
                    <textarea name="carFixDescription" rows="4" cols="50"></textarea>
                </label></p>
                <p><label>Wybierz status zamowienia
                    <select name="status_id">
                        <c:forEach var="status" items="${statuses}">
                            <option value="${status.id}">${status.status}</option>
                        </c:forEach>
                    </select>
                </label></p>
                <p><label>Wybierz pojazd do naprawy
                    <select name="vehicle_id">
                        <c:forEach var="vehicle" items="${vehicles}">
                            <option value="${vehicle.id}">${vehicle.model} ${vehicle.brand} ${vehicle.plateNumber}</option>
                        </c:forEach>
                    </select>
                </label></p>
                <p><label>Koszt naprawy: <input type="number" name="fixCosts" min="0" step="0.01"/></label></p>
                <p><label>Koszt części: <input type="number" name="partsCosts" min="0" step="0.01"/></label></p>
                <p><input type="submit" value="Dodaj"/></p>
            </form>
        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
