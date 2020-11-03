<%--
  Created by IntelliJ IDEA.
  User: ak_he
  Date: 03.11.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="./script/index.js"></script>
    <!--icons-->
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <!--CSS-->
    <link rel="stylesheet" href="./style/index.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<div class="box mx-auto my-5 ">

    <h2 class="text-center mb-4">Adding Books to the list</h2>
    <div>
        <div class="mx-auto mb-3">

            <form action="" method="GET">

                <div class="user-box mx-auto d-flex justify-content-center">
                    <input placeholder="Books" type="text" name="book" required="">
                    <a href="">
                        <i class='fas fa-search'></i>
                    </a>
                </div>

            </form>

        </div>

        <h4 class="text-center">Book List:</h4>
        <table class="mx-auto">
            <thead>
            <tr>
                <th><a href="">Name</a> </th>
                <th><a href="">Author</a> </th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>Name long</td>
                <td>Author long</td>
                <td>
                    <input type="checkbox" name="" id="">
                </td>

            </tr>
            <tr>
                <td>Name long</td>
                <td>Author long</td>
                <td>
                    <input type="checkbox" name="" id="">
                </td>

            </tr>
            <tr>
                <td>Name long</td>
                <td>Author long</td>
                <td>
                    <input type="checkbox" name="" id="">
                </td>

            </tr>
            <tr>
                <td>Name long</td>
                <td>Author long</td>
                <td>
                    <input type="checkbox" name="" id="">
                </td>

            </tr>
            <tr>
                <td>Name long</td>
                <td>Author long</td>
                <td>
                    <input type="checkbox" name="" id="">
                </td>

            </tr>
            <tr>
                <td>Name long</td>
                <td>Author long</td>
                <td>
                    <input type="checkbox" name="" id="">
                </td>

            </tr>

            </tbody>

        </table>


    </div>
    <a style="width: 40%;" class="btn mx-auto d-flex justify-content-center">
        Add books
    </a>

</div>

<%@include file=" footers/form.jsp" %>