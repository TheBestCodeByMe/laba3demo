<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Список пользователей</title>
</head>
<body>

<h3>Все пользователи:</h3>(<a href="add">добавить</a>)
<ol>
  <c:forEach items="${customers}" var="customer">
    <li>
        ${customer.zip} ${customer.name} ${customer.firstAddress} ${customer.secondAddress} ${customer.numbFax} ${customer.city}
      <a href="add?edit=${customer.id}">редактировать</a> | <a href="delete?id=${customer.id}">удалить</a>
    </li>
  </c:forEach>
</ol>
</body>
</html>