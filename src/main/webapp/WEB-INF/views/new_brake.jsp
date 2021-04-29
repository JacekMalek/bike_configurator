<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Konfigurator rowerowy</title>
    <link href="/style/style.css" rel="stylesheet"/>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>

<body>
<h3>Nowe hamulce:</h3>

<form:form method="post" modelAttribute="brakeDto">

    <p>
        Nazwa: <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </p>

    <p>
        Rodzaj: <form:select path="type" items="${type}" /><br>
        <form:errors path="type" cssClass="error"/>
    </p>

    <p>
        Producent: <form:select path="producer" items="${producer}" /><br>
        <form:errors path="producer" cssClass="error"/>
    </p>

    <p>
        Waga: <form:input path="weight"/>
        <form:errors path="weight" cssClass="error"/>
    </p>

    <p>
        Cena: <form:input path="price"/>
        <form:errors path="price" cssClass="error"/>
    </p>

    <p>
        <button class="btn btn-success" type="submit"><i class="fa fa-floppy-o fa-lg"></i> Zapisz</button>
        <a href="/brake/all"><input type="button" value="Powrót" class="btn btn-secondary"/></a>
    </p>


</form:form>

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
