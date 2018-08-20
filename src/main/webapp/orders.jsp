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
                <li class="breadcrumb-item active">Zlecenia</li>
            </ol>

            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <form action="" method="get">
                        <div class="form-group">
                            <div class="form-row">
                                <label for="employee" class="col-sm-4 col-form-label">Pokaż zlecenia pracownika:</label>
                                <div class="col-sm-5">
                                    <select id="employee" class="custom-select custom-select-sm form-control form-control-sm" name="employee_id" onchange="this.form.submit()">
                                        <option value="null">Wybierz pracownika</option>
                                        <c:forEach var="employee" items="${employees}">
                                            <c:choose>
                                                <c:when test="${employee_id==employee.id}">
                                                    <option value="${employee.id}" selected="selected">${employee.name} ${employee.surname}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${employee.id}">${employee.name} ${employee.surname}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-sm-12 col-md-6">
                    <p class="row no-gutters justify-content-end">
                        <a class="btn btn-primary" href="/order/add"><i class="fas fa-plus"></i> Dodaj nowe zlecenie</a>
                    </p>
                </div>
            </div>



            <div class="card mb-3">
                <div class="card-header">
                            <i class="fas fa-table"></i>
                            Lista zleceń
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Przyjęto</th>
                                <th>Planowana naprawa</th>
                                <th>Zakończono</th>
                                <th>Pracownik</th>
                                <th>Status</th>
                                <th>Koszt</th>
                                <th>Szczegóły</th>
                                <th>Edycja</th>
                                <th>Usuwanie</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th></th>
                                <th>Przyjęto</th>
                                <th>Planowana naprawa</th>
                                <th>Zakończono</th>
                                <th>Pracownik</th>
                                <th>Status</th>
                                <th>Koszt</th>
                                <th>Szczegóły</th>
                                <th>Edycja</th>
                                <th>Usuwanie</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="order" items="${orders}">
                                <tr>
                                    <td>${order.id}</td>
                                    <td>${order.admissionDate}</td>
                                    <td>${order.plannedServiceDate}</td>
                                    <td>${order.serviceDate}</td>
                                    <td>${order.employee.name} ${order.employee.surname}</td>
                                    <td>${order.status.status}</td>
                                    <td>${order.fixCosts}</td>
                                    <td><a href="/order/details?id=${order.id}"><i class="fas fa-list"></i></a></td>
                                    <td><a href="/order/edit?id=${order.id}"><i class="fas fa-pen"></i></a></td>
                                    <td><a href="/order/edit?id=${order.id}&del=true"><i class="fas fa-trash"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <p class="row no-gutters justify-content-end">
                <a class="btn btn-primary" href="/order/add"><i class="fas fa-plus"></i> Dodaj nowe zlecenie</a>
            </p>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
