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
                <li class="breadcrumb-item active">Klienci</li>
            </ol>

            <p><a class="btn btn-primary justify-content-end" href="/customer/add"><i class="fas fa-plus"></i> Dodaj nowego klienta</a></p>

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
                                <th>Imię</th>
                                <th>Nazwisko</th>
                                <th>Telefon</th>
                                <th>Dane</th>
                                <th>Samochody</th>
                                <th>Edycja</th>
                                <th>Usuwanie</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th></th>
                                <th>Imię</th>
                                <th>Nazwisko</th>
                                <th>Telefon</th>
                                <th>Dane</th>
                                <th>Samochody</th>
                                <th>Edycja</th>
                                <th>Usuwanie</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="customer" items="${customers}">
                                <tr>
                                    <td>${customer.id}</td>
                                    <td>${customer.getName()}</td>
                                    <td>${customer.surname}</td>
                                    <td>${customer.phonenumber}</td>
                                    <td><a href="/customer/details?id=${customer.id}"><i class="fas fa-list"></i></a></td>
                                    <td><a href="/vehicles?id=${customer.id}"><i class="fas fa-car"></i></a></td>
                                    <td><a href="/customer/edit?id=${customer.id}"><i class="fas fa-pen"></i></a></td>
                                    <td><a href="/customer/edit?id=${customer.id}&del=true"><i class="fas fa-trash"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <p><a class="btn btn-primary justify-content-end" href="/customer/add"><i class="fas fa-plus"></i> Dodaj nowego klienta</a></p>

    </div>
    <!-- /.container-fluid -->
    <%@ include file="WEB-INF/includes/footer.jspf" %>

    </body>
    </html>