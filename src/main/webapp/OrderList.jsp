<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pominov7
  Date: 12.10.2022
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: gray">
        <div>
            <a href="<%=request.getContextPath()%>/list" class="navbar-brand">На главную</a>
        </div>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">Список заказчиков</h3>
        <hr>
        <div class="container text-left" style="text-align: center">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Добавить</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Эл.почта</th>
                <th>Номер телефона</th>
                <th>Адрес</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="order" items="${listOrders}">

                <tr>
                    <td><c:out value="${order.idF}"/></td>
                    <td><c:out value="${order.nameF}"/></td>
                    <td><c:out value="${order.emailF}"/></td>
                    <td><c:out value="${order.phoneF}"/></td>
                    <td><c:out value="${order.addressF}"/></td>
                    <td><a href="edit?id=<c:out value='${order.idF}' />">Изменить</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?idF=<c:out value='${order.idF}' />">Удалить</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>