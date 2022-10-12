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
  <title>Страница заказов</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
          integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
          integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
          crossorigin="anonymous"></script>
</head>
<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: gray">
    <div>
      <a href="<%=request.getContextPath()%>/list" class="navbar-brand">Главная</a>
    </div>
  </nav>
</header>
<br>
<div class="container col-md-5">
  <div class="card">
    <div class="card-body">
      <c:if test="${order != null}">
      <form action="update" method="post">
        </c:if>
        <c:if test="${order == null}">
        <form action="insert" method="post">
          </c:if>

          <caption>
            <h2>
              <c:if test="${order != null}">
                Изменить
              </c:if>
              <c:if test="${order == null}">
                Добавить
              </c:if>
            </h2>
          </caption>

          <c:if test="${order != null}">
            <input type="hidden" name="idF" value="<c:out value='${order.idF}' />"/>
          </c:if>

          <fieldset class="form-group">
            <label>Имя</label> <input type="text"
                                                value="<c:out value='${order.nameF}' />"
                                                class="form-control"
                                                name="nameF" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>Эл.почта</label> <input type="text"
                                         value="<c:out value='${order.emailF}' />" class="form-control"
                                         name="emailF">
          </fieldset>

          <fieldset class="form-group">
            <label>Номер телефона</label> <input type="text"
                                              value="<c:out value='${order.phoneF}' />" class="form-control"
                                              name="phoneF">
          </fieldset>
          <fieldset class="form-group">
            <label>Адрес</label> <input type="text"
                                       value="<c:out value='${order.addressF}' />" class="form-control"
                                       name="addressF">
          </fieldset>

          <button type="submit" class="btn btn-success">Сохранить</button>
        </form>
    </div>
  </div>
</div>
</body>
</html>