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
    <title>Ramy</title>
    <link href="/style/style.css" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>
<div>
    <button type="button" class="btn btn-success"><a href="/frame/add"><i class="fa fa-plus"></i> Nowa rama</a></button></td>
</div>

<br>
<table class="table table-hover table-bordered" >
    <thead>
    <th>Nazwa</th>
    <th>Rozmiar</th>
    <th>Materiał</th>
    <th>Waga [kg]</th>
    <th>Cena [zł]</th>
    <th>Akcja</th>
    </thead>
    <tbody>
    <c:forEach items="${frame}" var="frame">
        <tr>
            <td><c:out value="${frame.name}"/></td>
            <td><c:out value="${frame.size}"/></td>
            <td><c:out value="${frame.material}"/></td>
            <td><c:out value="${frame.weight}"/> kg</td>
            <td><c:out value="${frame.price}"/> zł</td>

            <td><a href="/frame/edit/${frame.id}"><input type="button" value="Edytuj" class="btn btn-secondary"/></a>
                <button type="button" class="btn btn-danger"><a href="/frame/delete/${frame.id}"><i class="fa fa-trash-o fa-lg"></i> Usuń </a></button></td>
        </tr>
    </c:forEach>
    </tbody>


</table>
<a href="/bike/all"><input type="button" value="Powrót" class="btn btn-secondary"/></a>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script