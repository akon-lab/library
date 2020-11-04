<%@include file="headers/profile.jsp" %>

<div class="box mx-auto">
    <div class="  mb-3">
        <h3>Name: <c:out value="${user.name}"/></h3>
        <h4>Email: <c:out value="${user.email}"/></h4>
        <div class="row d-flex justify-content-around">
            <a class="btn" href="${pageContext.request.contextPath}/user?action=update&id=<c:out value="${user.id}"/>">
                Update
            </a>
            <a class="btn" href="${pageContext.request.contextPath}/user?action=remove&id=<c:out value="${user.id}"/>">
                Remove
            </a>
        </div>
    </div>
    <div class=" list">
        <h4>List of Books:</h4>
        <ul>
            <c:if test="${user.bookList!=null}">
                <c:forEach items="${user.bookList}" var="book">
                    <li class="d-flex justify-content-between">
                        <c:out value="${book.title}"/>
                        <a href="${pageContext.request.contextPath}/user?action=removeFromList&book=<c:out value="${book.id}"/>&user=<c:out value="${user.id}"/>">
                            <i class='far fa-trash-alt'></i>
                        </a>
                    </li>
                </c:forEach>
            </c:if>

            <li class="text-center">
                <a href="${pageContext.request.contextPath}/book?action=listBook&id=<c:out value="${user.id}"/>">
                    <strong>Add book</strong>
                </a>
            </li>
        </ul>
    </div>
</div>
<%@include file="footers/form.jsp" %>
