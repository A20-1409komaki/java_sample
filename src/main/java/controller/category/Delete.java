package controller.category;

import model.category.Category;
import model.task.Task;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/category/delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        int id = Integer.parseInt(req.getParameter("categoryid"));

        Category category = new Category(
                id,
                null,
                null,
                null,
                null,
                user.getId()
        );

        category.delete();

        resp.sendRedirect("/task/read");
    }
}