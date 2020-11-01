package servlet;

import controller.UserController;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UserServlet extends HttpServlet {
    private final UserController userController = new UserController();
    private final Set<String> message = new HashSet<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fname = req.getParameter("fname");
        String sname = req.getParameter("sname");

        userController.add(new UserModel(fname + " " +sname,email,password,null ) );

        req.setAttribute("message", message.add("Welcome back " + fname + " " +sname + "!"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        /*
        Cookie cookie = new Cookie("user", username);
        cookie.setMaxAge(60);
        resp.addCookie(cookie);
        */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Integer id = Integer.parseInt(req.getParameter("id"));

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

        String action = req.getParameter("action");

        if (action != null) {
            if (action.equals("update")) {
                userController.update(new UserModel());
            } else if (action.equals("add")) {
                userController.add(new UserModel());
            } else if (action.equals("remove")) {
                userController.remove(id);
            }
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
