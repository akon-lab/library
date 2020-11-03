package servlet;

import controller.BookController;
import controller.UserController;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogServlet extends HttpServlet {
    private final UserController userController = new UserController();
    private final BookController bookController = new BookController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("all", bookController.getAll());
        req.setAttribute("users", userController.getAll());

        getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);
/*
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        UserModel user = userController.getUserByEmail(email.trim());
        if (user != null) {

            if (user.getPassword().equals(password)) {
                req.setAttribute("all", bookController.getAll());
                req.setAttribute("users", userController.getAll());

                getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
            }
        } else {

        }
        getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);*/
    }
}
