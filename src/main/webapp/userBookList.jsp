<%@include file="headers/admin.jsp"%>

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

            <c:if test="${all!=null}">
                <c:forEach items="${all}" var="book">
                    <tr>
                        <td><c:out value="${book.title}"/></td>
                        <td><c:out value="${book.author}"/></td>
                        <td>
                            <input type="checkbox" value="<c:out value="${book.id}"/>" name="co" id="">
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

            </tbody>

        </table>


    </div>
    <a style="width: 40%;" onclick="checkbox()" class="btn mx-auto d-flex justify-content-center">
        Add books
    </a>

</div>

<%@include file="footers/form.jsp" %>