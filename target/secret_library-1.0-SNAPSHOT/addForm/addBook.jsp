 <%@include file="../headers/form.jsp"%>

    <div class="login-box">
        <h2>Add Book</h2>
        <form action="${pageContext.request.contextPath}/book?action=add" method="POST">
            <div class="user-box">
                <input type="text" name="name" required="">
                <label>Name</label>
            </div>
            <div class="user-box">
                <input type="text" name="author" required="">
                <label>Author</label>
            </div>
            <div class="user-box">
                <input type="number" name="copy" required="">
                <label>Copy</label>
            </div>
            <button type="submit">
                <span></span>
                <span></span>
                <span></span>
                <span></span> Add
            </button>
        </form>
    </div>

 <%@include file="../footers/form.jsp"%>