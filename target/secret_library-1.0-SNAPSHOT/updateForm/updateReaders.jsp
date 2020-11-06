<%@include file="../headers/form.jsp"%>

    <div class="login-box">
        <h2>Update Readers</h2>
        <form action="${pageContext.request.contextPath}/user?action=update&id=<c:out value="${user.id}"/>" method="POST">
            <div class="user-box">
                <input type="text" value="<c:out value="${user.name}"/>" name="name" required="">
                <label>Name</label>
            </div>
            <div class="user-box">
                <input type="text" value="<c:out value="${user.email}"/>" name="email" required="">
                <label>Email</label>
            </div>
            <div class="user-box">
                <input type="password" value="<c:out value="${user.password}"/>" name="password" required="">
                <label>Password</label>
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