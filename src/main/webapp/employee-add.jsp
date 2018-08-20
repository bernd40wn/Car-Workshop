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
                    <a href="/employees">Pracownicy</a>
                </li>
                <li class="breadcrumb-item active">Dodaj pracownika</li>
            </ol>

            <c:if test="${not empty success}">
                <div class="card card-register mx-auto mt-5">
                    <div class="card-body"><span style="color: lawngreen; font-weight: bold;">Pomyślnie dodano pracownika do bazy</span></div>
                </div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="card card-register mx-auto mt-5">
                    <div class="card-body"><span style="color: red; font-weight: bold;">BŁĄD: nie udało się dodac pracownika do bazy</span></div>
                </div>
            </c:if>

            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Dodaj nowego pracownika</div>
                <div class="card-body">

                    <form action="" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="text" id="name" name="name" class="form-control" placeholder="Imię:"/>
                                        <label for="name">Imię:</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="text" id="surname" name="surname" class="form-control"  placeholder="Nazwisko:"/>
                                        <label for="surname">Nazwisko:</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="address" name="address"  class="form-control"  placeholder="Adres:"/>
                                <label for="address">Adres:</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="text" id="phone" name="phone"  class="form-control"  placeholder="Telefon:" />
                                        <label for="phone">Telefon:</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="number" name="hourlyrate" class="form-control"  min="0" step="0.01" />
                                        <label>Stawka godzinowa:</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                                <label for="note">Nota:</label>
                                <textarea class="form-control" rows="5" id="note" name="note" placeholder="Nota:"></textarea>

                            </div>
                        </div>
                        <input type="submit" value="Dodaj"  class="btn btn-primary btn-block" />

                    </form>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>