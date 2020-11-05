package servlet;

import controller.BookController;
import controller.UserController;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LogServlet extends HttpServlet {
    private final UserController userController = new UserController();
    private final BookController bookController = new BookController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter p = resp.getWriter();

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    p.println("JSESSIONID=" + cookie.getValue());
                }
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        //invalidate the session if exists
        HttpSession session = req.getSession();
        p.println("User=" + session.getAttribute("user"));
        if (session != null) {
            session.setMaxInactiveInterval(-1);
        }
        req.getRequestDispatcher("/log.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");

        UserModel user = userController.getUserByEmail(email);
        if (user != null) {
            if (email.equals("admin@mail.ru") && pwd.equals("12345")) {
                HttpSession session = req.getSession();
                session.setAttribute("user", "admin");
                session.setMaxInactiveInterval(2 * 60 * 60);

                Cookie userName = new Cookie("user", email);
                userName.setMaxAge(2 * 60 * 60);
                resp.addCookie(userName);

                req.setAttribute("all", bookController.getAll());
                req.setAttribute("users", userController.getAll());

                req.getRequestDispatcher("/admin.jsp").forward(req, resp);
            } else {
                PrintWriter p = resp.getWriter();
                p.println("user name or password is wrong.");

                req.getRequestDispatcher("/log.jsp").forward(req, resp);
            }
        } else {
            PrintWriter p = resp.getWriter();
            p.println("user name or password is wrong.");

            req.getRequestDispatcher("/log.jsp").forward(req, resp);
        }

    }
}
