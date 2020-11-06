<%@include file="../headers/form.jsp"%>

    <div class="login-box">
        <h2>Update Book</h2>
        <form action="${pageContext.request.contextPath}/book?action=update&id=<c:out value="${book.id}"/>" method="POST">
            <div class="user-box">
                <input type="text" value="<c:out value="${book.title}"/>" name="name" required="">
                <label>Name</label>
            </div>
            <div class="user-box">
                <input type="text" value="<c:out value="${book.author}"/>" name="author" required="">
                <label>Author</label>
            </div>
            <div class="user-box">
                <input type="number" value="<c:out value="${book.copy}"/>" name="copy" required="">
                <label>Copy</label>
            </div>

            <button type="submit">
                <span></span>
                <span></span>
                <span></span>
                <span></span> Update
            </button>

        </form>
    </div>


<%@include file="../footers/form.jsp"%>