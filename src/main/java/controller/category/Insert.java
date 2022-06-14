package controller.category;
import model.category.*;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/category/insert")
public class Insert extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/category/insert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String color = req.getParameter("color");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");


        Category category = new Category(
                null,
                name,
                color,
                null,
                null,
                user.getId()
        );

        category.insert();

        // 新規登録が終わったらログイン画面に遷移
        resp.sendRedirect("/task/read");
    }
}
