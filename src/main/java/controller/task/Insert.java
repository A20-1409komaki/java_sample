package controller.task;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/task/insert")
public class Insert extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");
        ArrayList<Category> categories = Category.indexCategories(user);
        req.setAttribute("categories", categories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/task/insert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String place = req.getParameter("place");
        Float importance = Float.valueOf(req.getParameter("importance"));
        String memo = req.getParameter("memo");
        Date dueAt = java.sql.Date.valueOf(req.getParameter("dueAt"));
        Integer categoryId = Integer.valueOf(req.getParameter("categoryId"));

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        Task task = new Task(
                null,
                name,
                place,
                importance,
                memo,
                dueAt,
                null,
                null,
                0,
                user.getId(),
                categoryId
        );

        task.insert();

        // 新規登録が終わったらログイン画面に遷移
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }


}