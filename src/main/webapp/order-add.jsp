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
                <li class="breadcrumb-item active">Dodaj zlecenie</li>
            </ol>

            <c:if test="${not empty success}">
                <div class="card card-register mx-auto mt-5">
                    <div class="card-body"><span style="color: lawngreen; font-weight: bold;">Pomyślnie zmieniono zlecenie w bazie</span>
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="card card-register mx-auto mt-5">
                    <div class="card-body"><span style="color: red; font-weight: bold;">BŁĄD: nie zmieniono zlecenia w bazie</span>
                    </div>
                </div>
            </c:if>

            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Dodaj nowe zlecenie</div>
                <div class="card-body">

                    <form action="" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="date" id="admissionDate" name="admissionDate" class="form-control"
                                               placeholder="Data zgłoszenia:"/>
                                        <label for="admissionDate">Data zgłoszenia:</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="date" id="plannedServiceDate" name="plannedServiceDate"
                                               class="form-control" placeholder="Pln. data serwisu:"/>
                                        <label for="plannedServiceDate">Planowana data serwisu</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="date" id="serviceDate" name="serviceDate" class="form-control"
                                       placeholder="Data serwisu:"/>
                                <label for="serviceDate">Data serwisu:</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="employee">Wybierz pracownika:</label>
                                </div>
                                <div class="col-md-6">
                                    <select id="employee"
                                            class="custom-select custom-select-sm form-control form-control-sm"
                                            name="employee_id">
                                        <c:forEach var="employee" items="${employees}">

                                                    <option value="${employee.id}">${employee.name} ${employee.surname} </option>

                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="carProblemDescription" name="carProblemDescription"
                                       class="form-control" placeholder="Opis problemu:"/>
                                <label for="carProblemDescription">Opis problemu:</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="carFixDescription" name="carFixDescription" class="form-control"
                                       placeholder="Opis naprawy:" value="${order.carFixDescription}"/>
                                <label for="carFixDescription">Opis naprawy:</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="status">Status zlecenia:</label>
                                </div>
                                <div class="col-md-6">
                                    <select id="status"
                                            class="custom-select custom-select-sm form-control form-control-sm"
                                            name="status_id">
                                        <c:forEach var="status" items="${statuses}">

                                                    <option value="${status.id}">${status.status}</option>

                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="vehicle">Wybierz pojazd do naprawy:</label>
                                </div>
                                <div class="col-md-6">
                                    <select id="vehicle"
                                            class="custom-select custom-select-sm form-control form-control-sm"
                                            name="vehicle_id">
                                        <c:forEach var="vehicle" items="${vehicles}">

                                                    <option value="${vehicle.id}">${vehicle.brand} ${vehicle.model}, ${vehicle.plateNumber}</option>

                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input id="fixCosts" type="number" name="fixCosts" class="form-control"
                                               placeholder="Koszta naprawy:" min="0" step="0.01"/>
                                        <label for="fixCosts">Koszta naprawy:</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input id="partsCosts" type="number" name="partsCosts" class="form-control"
                                               placeholder="Koszta części:"  min="0" step="0.01" />
                                        <label for="partsCosts">Koszta częsci:</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="Dodaj" class="btn btn-primary btn-block"/>

                    </form>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
