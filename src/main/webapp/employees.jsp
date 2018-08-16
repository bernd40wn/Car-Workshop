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
                <li class="breadcrumb-item active">Pracownicy</li>
            </ol>

            <h2>Pracownicy</h2>

            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Lista pracowników</div>
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
                                <th>Zlecenia</th>
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
                                <th>Zlecenia</th>
                                <th>Edycja</th>
                                <th>Usuwanie</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="employee" items="${employeeList}">
                                <tr>
                                    <td>${employee.id}</td>
                                    <td>${employee.getName()}</td>
                                    <td>${employee.surname}</td>
                                    <td><a href="/employee/details?id=${employee.id}">[D]</a></td>
                                    <td><a href="/orders?emp_id=${employee.id}">[Z]</a></td>
                                    <td><a href="/employee/edit?id=${employee.id}">[E]</a></td>
                                    <td><a href="/employee/edit?id=${employee.id}&del=true">[U]</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>



<ul>
    <li><a href="/employee/add">Dodaj nowego pracownika</a></li>
</ul>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
