<%@include file="../headers/form.jsp"%>

    <div class="login-box">
        <h2>Add Readers</h2>
        <form action="${pageContext.request.contextPath}/user?action=add" method="POST">
            <div class="user-box">
                <input type="text" name="name" required="">
                <label>Name</label>
            </div>
            <div class="user-box">
                <input type="text" name="email" required="">
                <label>Email</label>
            </div>
            <div class="user-box">
                <input type="password" name="password" required="">
                <label>Password</label>
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