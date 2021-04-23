<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl_PL">
<head>
    <title>Konfigurator rowerowy</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Rowery</title>
    <link href="/style/style.css" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>
<div>
    <div>
        <h2>Nasze rowery:</h2>
    </div>
<div class="form-group">
    <label for="Select">Sortuj według:</label>
    <select class="form-control" id="Select">
        <option>Nazwa</option>
        <option>Cena</option>
        <option>Waga</option>
    </select>
</div>

    <button type="button" class="btn btn-success"><a href="/bike/add"><i class="fa fa-plus"></i> Nowy rower</a></button></td>
    <%--    <button type="button" class="btn btn-success"><a href="/part/add"><i class="fa fa-plus"></i> Nowa część</a></button></td>--%>
    <%--    <button type="button" class="btn btn-success"><a href="/category/add"><i class="fa fa-plus"></i> Nowa kategoria</a></button></td>--%>
    <button type="button" class="btn btn-success"><a href="/frame/add"><i class="fa fa-plus"></i> Nowa rama</a></button></td>
    <button type="button" class="btn btn-success"><a href="/wheel/add"><i class="fa fa-plus"></i> Nowe koła</a></button></td>
    <button type="button" class="btn btn-success"><a href="/frame/all"><i class="btn btn-primary" ></i> Wszystkie ramy</a></button></td>
    <button type="button" class="btn btn-success"><a href="/wheel/all"><i class="btn btn-primary" ></i> Wszystkie koła</a></button></td>
</div>
<br>
<table class="table table-hover table-bordered" >
    <thead>
    <th>Nazwa</th>
    <th>Cena</th>
    <th>Waga</th>
    <th>Szczegóły</th>
    <th>Akcja</th>
    </thead>
    <tbody>
    <c:forEach items="${bikes}" var="bike">
        <tr>
            <td><c:out value="${bike.name}"/></td>
            <td><c:out value="${bike.price}"/></td>
            <td><c:out value="${bike.weight}"/></td>
            <td><a href="/bike/details/${bike.id}"><input type="button" value="Pokaż" class="btn btn-primary" /></a></td>
            <td><a href="/bike/edit/${bike.id}"><input type="button" value="Edytuj" class="btn btn-secondary"/></a>
                <button type="button" class="btn btn-danger"><a href="/bike/delete/${bike.id}"><i class="fa fa-trash-o fa-lg"></i> Usuń </a></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>