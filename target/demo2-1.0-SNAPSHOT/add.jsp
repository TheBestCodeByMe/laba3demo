<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавление | Редактирование</title>
</head>
<body>

<form action="add" method="post">
  <label for="zip">Введите zip:
    <input type="text" id="zip" value="${customer.zip}" name="zip" />
  </label>  <br />
  <label for="name">Введите имя:
    <input type="text" id="name" value="${customer.name}" name="name" />
  </label>  <br />
  <label for="firstAddress">Введите 1 адрес:
    <input type="text" id="firstAddress" value="${customer.firstAddress}" name="firstAddress" />
  </label>  <br />
  <label for="secondAddress">Введите 2 адрес:
    <input type="text" id="secondAddress" value="${customer.secondAddress}" name="secondAddress" />
  </label>  <br />
  <label for="numbFax">Введите номер факса:
    <input type="text" id="numbFax" value="${customer.numbFax}" name="numbFax" />
  </label>  <br />
  <label for="city">Введите город:
    <input type="text" id="city" value="${customer.city}" name="city" />
  </label>  <br />
  <input type="hidden" name="id" value="${customer.id}" />
  <input type="submit" value="Сохранить" />
</form>

</body>
</html>