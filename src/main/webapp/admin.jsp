<%@include file="headers/admin.jsp" %>

<div class="box mx-auto my-5">
    <h3 class="text-center">
        Admin Page
        <!--logout button in 8 line-->
        <a href="${pageContext.request.contextPath}/admin.jsp">
            <span><a href=""><i class='fas fa-door-open'></i></a></span>
        </a>
    </h3>
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
                <th><a href="">Name</a></th>
                <th><a href="">Author</a></th>
                <th><a href="">Copy</a></th>
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
                        <td><c:out value="${book.copy}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book?action=remove&id=<c:out value="${book.id}"/>">
                                <i class='far fa-trash-alt'></i>
                            </a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book?action=update&id=<c:out value="${book.id}"/>">
                                <i class='fas fa-pen-alt'></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>


            <tr>
                <td class="text-center" colspan="5" style="border-top: 2px solid  #6cf;">
                    <a href="${pageContext.request.contextPath}/book?action=add">
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
                    <input placeholder="Readers" id="searchUser" type="text" name="reader" required="">
                    <button onclick="searchUser()">
                        <i class='fas fa-search'></i>
                    </button>
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
            <c:if test="${userList!=null}">
                <c:forEach items="${userList}" var="reader">
                    <tr>
                        <td>
                            <a href="">
                                <c:out value="${userList.name}"/>
                            </a>
                        </td>
                        <td><c:out value="${userList.email}"/></td>
                        <td><c:out value="${userList.bookList.size()}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user?action=remove&id=<c:out value="${userList.id}"/>">
                                <i class='far fa-trash-alt'></i>
                            </a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user?action=update&id=<c:out value="${userList.id}"/>">
                                <i class='fas fa-pen-alt'></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${users!=null && readerSearchResult==null}">
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/user?action=prof&id=<c:out value="${user.id}"/>">
                                <c:out value="${user.name}"/>
                            </a>
                        </td>
                        <td><c:out value="${user.email}"/></td>

                        <td><c:out value="${user.bookList.size()}"/></td>


                        <td>
                            <a onclick="removeUser(<c:out value="${user.bookList.size()}"/>,<c:out
                                    value="${user.id}"/>)">
                                <i class='far fa-trash-alt'></i>
                            </a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user?action=update&id=<c:out value="${user.id}"/>">
                                <i class='fas fa-pen-alt'></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

            <tr>
                <td class="text-center" colspan="5" style="border-top: 2px solid  #6cf;">
                    <a href="${pageContext.request.contextPath}/user?action=add">
                        <strong>Add</strong>
                    </a>
                </td>
            </tr>
            </tbody>

        </table>
    </div>


</div>


<%@include file="/footers/form.jsp" %>