<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link rel="stylesheet" href="./style/profile.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

    <div class="box mx-auto">
        <div class="  mb-3">
            <h3>Name: <c:out value="${user.name}"/></h3>
            <h4>Email: <c:out value="${user.email}"/></h4>
            <div class="row d-flex justify-content-around">
                <a class="btn">
                    Update
                </a>
                <a class="btn">
                    Remove
                </a>
            </div>
        </div>
        <div class=" list">
            <h4>List of Books:</h4>
            <ul>
                <li class="d-flex justify-content-between">
                    Fisrt Book
                    <a href="">
                        <i class='far fa-trash-alt'></i>
                    </a>
                </li>
                <li class="d-flex justify-content-between">
                    Second Book
                    <a href="">
                        <i class='far fa-trash-alt'></i>
                    </a>
                </li>
                <li class="d-flex justify-content-between">
                    Second Book
                    <a href="">
                        <i class='far fa-trash-alt'></i>
                    </a>
                </li>
                <li class="text-center">
                    <a href="">
                        <strong>Add book</strong>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>