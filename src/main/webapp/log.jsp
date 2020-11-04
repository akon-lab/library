<%@include file="headers/form.jsp"%>

    <div class="login-box">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/log" method="get">
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
                <span></span> Submit
            </button>

        </form>
    </div>

<%@include file="footers/form.jsp" %>