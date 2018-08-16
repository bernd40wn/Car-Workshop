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
                    <a href="/vehicles">Samochody</a>
                </li>
                <li class="breadcrumb-item active">Dodaj nowy samochód</li>
            </ol>

            <h2>Dodaj nowy samochód</h2>

            <p>tu będzie formularz</p>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
