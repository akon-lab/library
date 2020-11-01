<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <div class="box mx-auto my-5">

        <h3 class="text-center">Admin Page</h3>
        <div class="col d-flex mb-5">

            <a class="btn mx-auto" onclick="btn(readersList)">
                List of Readers
            </a><br>
            <a class="btn mx-auto" onclick="btn(bookList)">
                list of Book
            </a>

        </div>


        <div id="bookList">
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
                    <th><a href="">Copy</a> </th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>

                <tbody>
                <c:if test="${all!=null}">
                    <c:forEach items="${all}" var="book">
                        <tr>
                            <td><c:out value="${book.title}"/></td>
                            <td><c:out value="${book.author}"/></td>
                            <td><c:out value="${book.price}"/></td>
                            <td>
                                <a href="">
                                    <i class='far fa-trash-alt'></i>
                                </a>
                            </td>
                            <td>
                                <a href="">
                                    <i class='fas fa-pen-alt'></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>


                <tr>
                    <td class="text-center" colspan="5" style="border-top: 2px solid  #6cf;">
                        <a href="">
                            <strong>Add</strong>
                        </a>
                    </td>
                </tr>

                </tbody>

            </table>
        </div>

        <div id="readersList">

            <div class="mx-auto mb-3">

                <form action="" method="GET">

                    <div class="user-box mx-auto d-flex justify-content-center">
                        <input placeholder="Readers" type="text" name="book" required="">
                        <a href="">
                            <i class='fas fa-search'></i>
                        </a>
                    </div>

                </form>

            </div>

            <h4 class="text-center">Readers List:</h4>
            <table class="mx-auto">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Count of book</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <a href="">
                            Name long long
                        </a>
                    </td>
                    <td>Email</td>
                    <td>Count</td>
                    <td>
                        <a href="">
                            <i class='far fa-trash-alt'></i>
                        </a>
                    </td>
                    <td>
                        <a href="">
                            <i class='fas fa-pen-alt'></i>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="">
                            Name
                        </a>
                    </td>
                    <td>Email</td>
                    <td>Count</td>
                    <td>
                        <a href="">
                            <i class='far fa-trash-alt'></i>
                        </a>
                    </td>
                    <td>
                        <a href="">
                            <i class='fas fa-pen-alt'></i>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td class="text-center" colspan="5" style="border-top: 2px solid  #6cf;">
                        <a href="">
                            <strong>Add</strong>
                        </a>
                    </td>
                </tr>
                </tbody>

            </table>
        </div>


    </div>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>