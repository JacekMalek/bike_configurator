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
    <h2>Szczegółowa specyfikacja roweru:</h2>
</div>
<div class="list-group">
    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Nazwa roweru:</h5>
        </div>
        <p class="mb-1">
        <c:out value="${bike.name}"/>
        </p>
    </a>
    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Szczegóły ramy:</h5>
        </div>
        <p class="mb-1">
        <li>Nazwa ramy: <c:out value="${bike.frame.name}"/></li>
        <li>Materiał ramy: <c:out value="${bike.frame.material}"/></li>
        <li>Rozmiar ramy: <c:out value="${bike.frame.size}"/></li>
        <li>Waga ramy: <c:out value="${bike.frame.weight}"/> kg</li>
        <li>Cena ramy: <c:out value="${bike.frame.price}"/> zł</li>
        </p>
    </a>
    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Szczegóły kół:</h5>
        </div>
        <p class="mb-1">
        <li>Nazwa kół: <c:out value="${bike.wheel.name}"/></li>
        <li>Rozmiar kół: <c:out value="${bike.wheel.size}"/>'</li>
        <li>Waga kół: <c:out value="${bike.wheel.weight}"/> kg</li>
        <li>Cena kół: <c:out value="${bike.wheel.price}"/> zł</li>

        </p>
    </a>

    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Szczegóły hamulców:</h5>
        </div>
        <p class="mb-1">
        <li>Nazwa hamulców: <c:out value="${bike.brake.name}"/></li>
        <li>Typ hamulców: <c:out value="${bike.brake.type}"/></li>
        <li>Producent hamulców: <c:out value="${bike.brake.producer}"/></li>
        <li>Waga hamulców: <c:out value="${bike.brake.weight}"/> kg</li>
        <li>Cena hamulców: <c:out value="${bike.brake.price}"/> zł</li>


        </p>
    </a>

    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start active">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Podsumowanie:</h5>
        </div>
        <p class="mb-1">
        <div>Waga roweru: <c:out value="${bike.weight}"/> kg</div>
        <div>Cena roweru: <c:out value="${bike.price}"/> zł</div>
        </p>
    </a>
</div>
<br>
<a href="/pdfRaportSelectedBike/${bike.id}"><input type="button" value="Raport PDF" class="btn btn-primary"/></a>
<a href="/"><input type="button" value="Powrót" class="btn btn-secondary"/></a>

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