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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Rowery</title>
    <link href="/style/style.css" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>
<div>
    <div>
        <h2>Nasze rowery:</h2>
    </div>
    <div class="pull-right">
        <h5 class="btn btn-outline-secondary"> W Naszej bazie jest już <c:out value="${count}"/> rowerów </h5>
    </div>
    <div class="form-group">
        <br>
        <div>Sortuj według:</div>
        <select class="form-control" id="Select" onchange="location = this.value;">
            <option>Wybierz sposób sortowania </option>
            <option value="/allByName">Po nazwie</option>
            <option value="/allByPriceAscending">Po cenie od najniższej</option>
            <option value="/allByPrice">Po cenie od najwyższej</option>
            <option value="/allByWeightAscending">Po wadze od najniższej</option>
            <option value="/allByWeight">Po wadze od najwyższej</option>
        </select>
    </div>

    <button type="button" class="btn btn-success"><a href="/add"><i class="fa fa-plus"></i> Nowy rower</a></button>

    <div class='pull-right'>

        <td>
            <button type="button" class="btn btn-success"><a href="/new_part/"><i class="fa fa-plus"></i> Nowa część</a>
            </button>
        </td>

        <td>
            <button type="button" class="btn btn-success"><a href="/all_parts/"><i class="btn btn-primary"></i> Wszystkie części</a></button>
        </td>

        <td>
            <a href="/pdfRaport"><input type="button" value="Zestawienie rowerów" class="btn btn-primary"/></a>
        </td>


    </div>
</div>
<br>
<table class="table table-hover table-bordered">
    <thead>
    <th>Nazwa</th>
    <th>Cena [zł]</th>
    <th>Waga [kg]</th>
    <th>Szczegóły</th>
    <th>Akcja</th>
    </thead>
    <tbody>
    <c:forEach items="${bikes}" var="bike">
        <tr>
            <td><c:out value="${bike.name}"/></td>
            <td><c:out value="${bike.price}"/> zł</td>
            <td><c:out value="${bike.weight}"/> kg</td>
            <td><a href="/details/${bike.id}"><input type="button" value="Pokaż szczegóły" class="btn btn-primary"/></a></td>
            <td><a href="/edit/${bike.id}"><input type="button" value="Edytuj" class="btn btn-secondary"/></a>
                <button type="button" class="btn btn-danger"><a href="/delete/${bike.id}">
                    <i class="fa fa-trash-o fa-lg"></i> Usuń </a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>
</html>