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
                <li class="breadcrumb-item active">Szczegóły zlecenia</li>
            </ol>

            <div class="card card-register mx-auto mt-5">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Szczegóły zlecenia</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <tbody>
                            <tr>
                                <th scope="row">Data przyjecia zlecenia</th>
                                <td>${order.admissionDate}</td>
                            </tr>
                            <tr>
                                <th scope="row">Planowana data serwisu</th>
                                <td>${order.plannedServiceDate}</td>
                            </tr>
                            <tr>
                                <th scope="row">Pracownik</th>
                                <td>${order.employee.name} ${order.employee.surname}</td>
                            </tr>
                            <tr>
                                <th scope="row">Opis problemu</th>
                                <td>${order.carProblemDescription}</td>
                            </tr>
                            <tr>
                                <th scope="row">Opis naprawy</th>
                                <td>${order.carFixDescription}</td>
                            </tr>
                            <tr>
                                <th scope="row">Status zlecenia</th>
                                <td>${order.status.status}</td>
                            </tr>
                            <tr>
                                <th scope="row">Serwisowany pojazd</th>
                                <td>${order.vehicle.brand} ${order.vehicle.model}, ${order.vehicle.plateNumber} </td>
                            </tr>
                            <tr>
                                <th scope="row">Koszta naprawy</th>
                                <td>${order.fixCosts}</td>
                            </tr>
                            <tr>
                                <th scope="row">Koszta części</th>
                                <td>${order.partsCosts}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <p>
                        <a class="btn btn-secondary" href="/orders">Powrót</a>
                    </p>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
