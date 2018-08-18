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
                    <a href="/customers">Klienci</a>
                </li>
                <li class="breadcrumb-item active">Dane pracownika</li>
            </ol>

            <div class="card card-register mx-auto mt-5">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Dane pracownika</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <tbody>
                            <tr>
                                <th scope="row">Imię</th>
                                <td>${employee.getName()}</td>
                            </tr>
                            <tr>
                                <th scope="row">Nazwisko</th>
                                <td>${employee.surname}</td>
                            </tr>
                            <tr>
                                <th scope="row">Telefon</th>
                                <td>${employee.phonenumber}</td>
                            </tr>
                            <tr>
                                <th scope="row">Adres zamieszkania</th>
                                <td>${employee.address}</td>
                            </tr>
                            <tr>
                                <th scope="row">Notatka</th>
                                <td>${employee.note}</td>
                            </tr>
                            <tr>
                                <th scope="row">Roboczogodziny</th>
                                <td>${employee.workhours}</td>
                            </tr>
                            <tr>
                                <th scope="row">Stawka godzinowa</th>
                                <td>${employee.hourlyrate}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <p>
                        <a class="btn btn-primary" href="/orders?emp_id=${employee.id}">Zlecenia pracownika</a>
                        <a class="btn btn-secondary" href="/employees">Powrót</a>
                    </p>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
