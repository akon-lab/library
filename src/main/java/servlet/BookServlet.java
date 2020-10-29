package servlet;

import controller.BookController;
import models.BookModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    private final BookController bookController = new BookController();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("update")) {
                bookController.update(new BookModel());
            } else if (action.equals("add")) {
                bookController.add(new BookModel());
            } else if (action.equals("remove")) {
                bookController.remove(id);
            }
        }



        getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
    }
}
