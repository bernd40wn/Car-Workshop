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
                <li class="breadcrumb-item active">Samochody</li>
            </ol>

            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <form action="" method="get">
                        <div class="form-group">
                            <div class="form-row">
                                <label for="customer" class="col-sm-3 col-form-label">Pokaż samochody klienta:</label>
                                <div class="col-sm-5">
                                <select id="customer" class="custom-select custom-select-sm form-control form-control-sm" name="customer_id" onchange="this.form.submit()">
                                    <option value="null">Wybierz klienta</option>
                                    <c:forEach var="customer" items="${customers}">
                                        <c:choose>
                                            <c:when test="${customer_id==customer.id}">
                                                <option value="${customer.id}" selected="selected">${customer.name} ${customer.surname}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${customer.id}">${customer.name} ${customer.surname}</option>
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
                        <a class="btn btn-primary" href="/vehicle/add"><i class="fas fa-plus"></i> Dodaj samochód</a>
                    </p>
                </div>
            </div>

            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Lista samochodów</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Model</th>
                                <th>Marka</th>
                                <th>Rok prod.</th>
                                <th>Tab. rejestr.</th>
                                <th>Następny przegląd</th>
                                <th>Edycja</th>
                                <th>Usuwanie</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th></th>
                                <th>Model</th>
                                <th>Marka</th>
                                <th>Rok prod.</th>
                                <th>Tab. rejestr.</th>
                                <th>Następny przegląd</th>
                                <th>Edycja</th>
                                <th>Usuwanie</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="vehicle" items="${vehicles}">
                                <tr>
                                    <td>${vehicle.id}</td>
                                    <td>${vehicle.brand}</td>
                                    <td>${vehicle.model}</td>
                                    <td>${vehicle.productionDate}</td>
                                    <td>${vehicle.plateNumber}</td>
                                    <td>${vehicle.nextService}</td>
                                    <td><a href="/vehicle/edit?id=${vehicle.id}"><i class="fas fa-pen"></i></a></td>
                                    <td><a href="/vehicle/edit?id=${vehicle.id}&del=true"><i class="fas fa-trash"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <p class="row no-gutters justify-content-end">
                <a class="btn btn-primary" href="/vehicle/add"><i class="fas fa-plus"></i> Dodaj samochód</a>
            </p>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
