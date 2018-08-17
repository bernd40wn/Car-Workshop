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
                    <a href="/vehicles">Samochody</a>
                </li>
                <li class="breadcrumb-item active">Edytuj samochód</li>
            </ol>

            <h2>Edytuj samochód</h2>

            <form action="" method="post">
                <p><label>Model: <input type="text" name="model" value="${vehicle.model}"/></label></p>
                <p><label>Marka: <input type="text" name="brand" value="${vehicle.brand}"/></label></p>
                <p><label>Rok prod.: <input type="date" name="productionDate" value="${vehicle.productionDate}"/></label></p>
                <p><label>Tab. rejestr.: <input type="text" name="plateNumber" value="${vehicle.plateNumber}"/></label></p>
                <p><label>Następny przegląd: <input type="date" name="nextService" value="${vehicle.nextService}"/></label></p>
                <p><label>
                Wybierz właściciela
                <select name="customer_id">
                    <c:forEach var="customer" items="${customers}">
                        <c:choose>
                            <c:when test="${vehicle.customer_id==customer.id}">
                                <option value="${customer.id}" selected="selected">${customer.name} ${customer.surname} </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${customer.id}">${customer.name} ${customer.surname} </option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                </label></p>
                <p><input type="submit" value="Zmien"/></p>
            </form>

        </div>
        <!-- /.container-fluid -->
        <%@ include file="WEB-INF/includes/footer.jspf" %>

</body>
</html>
