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

<h2>Zlecenia</h2>

            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Lista klientów</div>
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
                                    <td>${order.getServiceDate}</td>
                                    <td>${order.employee.name} ${order.employee.surname}</td>
                                    <td>${order.status.status}</td>
                                    <td>${order.fixCosts}</td>
                                    <td><a href="/order/details?id=${order.id}">[S]</a></td>
                                    <td><a href="/order/edit?id=${order.id}">[E]</a></td>
                                    <td><a href="/order/edit?id=${order.id}&del=true">[U]</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


            <ul>
    <li><a href="/order/add">Dodaj nowe zlecenie</a></li>
</ul>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
