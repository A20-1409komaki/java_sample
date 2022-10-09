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

@WebServlet("/category/update")
public class Update extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        ArrayList<Category> categories = Category.indexCategories(user);
        req.setAttribute("categories", categories);

        ArrayList<Task> tasks = Task.indexTasks(user);
        req.setAttribute("tasks", tasks);

        int id = Integer.parseInt(req.getParameter("categoryid"));

        Category category = new Category(
                id,
                null,
                null,
                null,
                null,
                user.getId()
        );

        category = category.search();
        req.setAttribute("currentcategory",category);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/category/update.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String color = req.getParameter("color");
        Integer id = Integer.parseInt(req.getParameter("categoryid"));
        User user = (User) req.getSession().getAttribute("currentUser");
        Integer userId = user.getId();

        Category category = new Category(
                id,
                name,
                color,
                null,
                null,
                userId
        );

        category.update();

        resp.sendRedirect("/task/read");
    }
}