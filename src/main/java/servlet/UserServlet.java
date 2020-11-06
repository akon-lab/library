package servlet;

import com.google.gson.Gson;
import controller.BookController;
import controller.UserController;
import models.BookModel;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {
    private final UserController userController = new UserController();
    private final BookController bookController=new BookController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String action = req.getParameter("action");

        if (action != null) {
            if (action.equals("update")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                UserModel userModel = userController.getItemById(id);
                userModel.setName(name);
                userModel.setEmail(email);
                userModel.setPassword(password);
                userController.update(userModel);

            } else if (action.equals("add")) {
                userController.add(new UserModel.UserBuilder(name)
                .withEmail(email)
                .withPassword(password)
                .build());
            }
        }
        req.setAttribute("all", bookController.getAll());
        req.setAttribute("users", userController.getAll());

        getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "update": {
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("user", userController.getItemById(id));
                    req.getRequestDispatcher("/updateForm/updateReaders.jsp").forward(req, resp);

                    break;
                }
                case "add":
                    req.getRequestDispatcher("/addForm/addReaders.jsp").forward(req, resp);

                    break;
                case "remove": {
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    userController.remove(id);

                    break;
                }
                case "search":
                    String reader = req.getParameter("reader");
                    ArrayList<UserModel> users = userController.serch(reader);

                    resp.setContentType("text/html;charset=UTF-8");
                    String json = new Gson().toJson(users);

                    resp.getWriter().write(json);
                    return;

                case "prof": {
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("user", userController.getItemById(id));
                    req.getRequestDispatcher("/profile.jsp").forward(req, resp);

                    break;
                }
                case "removeFromList": {
                    Integer book_id = Integer.parseInt(req.getParameter("book"));
                    Integer user_id = Integer.parseInt(req.getParameter("user"));
                    userController.removeBookFromUsersList(book_id, user_id);

                    break;
                }
                case "addToList": {
                    String listOfBook = req.getParameter("books");
                    Integer user_id = Integer.parseInt(req.getParameter("user"));
                    userController.addBookIntoUsersList(listOfBook, user_id);

                    resp.sendRedirect(req.getHeader("referer"));
                    break;
                }
            }
        }
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);

    }
}
