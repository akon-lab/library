package servlet;

import com.google.gson.Gson;
import controller.UserController;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {
    private final UserController userController = new UserController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String action = req.getParameter("action");

        if (action != null) {
            if (action.equals("update")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                userController.update(new UserModel(id, name, email, password, null));

            } else if (action.equals("add")) {
                userController.add(new UserModel(name, email, password, null));

            }
        }
        req.getRequestDispatcher("admin.jsp").forward(req, resp);


        /*
        Cookie cookie = new Cookie("user", username);
        cookie.setMaxAge(60);
        resp.addCookie(cookie);
        */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        String action = req.getParameter("action");

        if (action != null) {
            if (action.equals("update")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("user", userController.getItemById(id));
                req.getRequestDispatcher("/updateForm/updateReaders.jsp").forward(req, resp);

            } else if (action.equals("add")) {
                req.getRequestDispatcher("/addForm/addReaders.jsp").forward(req, resp);

            } else if (action.equals("remove")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                if (!userController.remove(id)) {
                    out.write("<script>\n" +
                            "alert(\"That user didn't return all book\");\n" +
                            "</script>");
                }


            } else if (action.equals("search")) {
                String reader = req.getParameter("reader");
                ArrayList<UserModel> users = userController.serch("dil");

                resp.setContentType("text/html;charset=UTF-8");
                String json = new Gson().toJson(users);

                resp.getWriter().write(json);
                return;

            } else if (action.equals("prof")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("user", userController.getItemById(id));
                req.getRequestDispatcher("/profile.jsp").forward(req, resp);

            } else if (action.equals("removeFromList")) {
                Integer book_id = Integer.parseInt(req.getParameter("book"));
                Integer user_id = Integer.parseInt(req.getParameter("user"));
                userController.removeBookFromUsersList(book_id, user_id);

            }else if (action.equals("addToList")) {
                String listOfBook =  req.getParameter("books");
                Integer user_id = Integer.parseInt(req.getParameter("user"));
                userController.addBookIntoUsersList(listOfBook,user_id);

                resp.sendRedirect(req.getHeader("referer"));
            }
        }
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);

    }
}
