package servlet;

import controller.BookController;
import controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogServlet extends HttpServlet {
    private final UserController userController=new UserController();
    private final BookController bookController = new BookController();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("all", bookController.getAll());
        req.setAttribute("users", userController.getAll());

        getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);  /*
        //authorization
        if (userController.findUserByUsername(username) != null) {
            UserModel user = userController.findUserByUsername(username);
            if (user.getPassword().equals(password)) {
                req.setAttribute("message", message.add("Welcome back " + username + "!"));
            } else {
                req.setAttribute("message", message.add("Your password not correct"));
            }
        } else {
            req.setAttribute("message", message.add("Such user not exist"));
        }
       * */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("all", bookController.getAll());

        getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}
