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
                <li class="breadcrumb-item active">Edytuj zlecenie</li>
            </ol>

            <h2>Edytuj zlecenie</h2>

            <form action="" method="post">
                <p><label>Data przyjecia: <input type="date" name="admissionDate" value="${order.admissionDate}"/></label></p>
                <p><label>Data planowanego serwisu: <input type="date" name="plannedServiceDate" value="${order.plannedServiceDate}"/></label></p>
                <p><label>Data serwisu: <input type="date" name="serviceDate" value="${order.serviceDate}"/></label></p>
                <p><label>Wybierz pracownika
                    <select name="employee_id">
                        <c:forEach var="employee" items="${employees}">
                            <c:choose>
                                <c:when test="${order.employee_id==2}">
                                    <option value="${employee.id}"
                                            selected="selected">${employee.name} ${employee.surname} </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${employee.id}">${employee.name} ${employee.surname} </option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </label></p>
                <p><label>Opis problemu:
                    <textarea name="carProblemDescription" rows="4" cols="50">${order.carProblemDescription}</textarea>
                </label></p>
                <p><label>Opis naprawy:
                    <textarea name="carFixDescription" rows="4" cols="50">${order.carFixDescription}</textarea>
                </label></p>
                <p><label>Wybierz status zamowienia
                    <select name="status_id">
                        <c:forEach var="status" items="${statuses}">
                            <c:choose>
                                <c:when test="${order.status_id==status.id}">
                                    <option value="${status.id}" selected="selected">${status.status}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${status.id}">${status.status}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </label></p>
                <p><label>Wybierz pojazd do naprawy
                    <select name="vehicle_id">
                        <c:forEach var="vehicle" items="${vehicles}">
                            <c:choose>
                                <c:when test="${order.vehicle_id==vehicle.id}">
                                    <option value="${vehicle.id}"
                                            selected="selected">${vehicle.model} ${vehicle.brand} ${vehicle.plateNumber}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${vehicle.id}">${vehicle.model} ${vehicle.brand} ${vehicle.plateNumber}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </label></p>
                <p><label>Koszt naprawy: <input type="number" name="fixCosts" min="0" step="0.01"
                                                value="${order.fixCosts}"/></label></p>
                <p><label>Koszt części: <input type="number" name="partsCosts" min="0" step="0.01"
                                               value="${order.partsCosts}"/></label></p>
                <p><input type="submit" value="Dodaj"/></p>
            </form>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
