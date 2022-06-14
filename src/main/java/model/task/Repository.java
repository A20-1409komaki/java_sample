package model.task;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insert(Task task) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            String sql = "insert into tasks (name, place, importance, memo, due_at, created_at, updated_at, completion,  users_id, categories_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getPlace());
            stmt.setFloat(3, task.getImportance());
            stmt.setString(4, task.getMemo());
            stmt.setDate(5, (Date) task.getDueAt());
            stmt.setTimestamp(6, currentTime);
            stmt.setTimestamp(7, currentTime);
            stmt.setInt(8, task.getCompletion());
            stmt.setInt(9, task.getUserId());
            stmt.setInt(10, task.getCategoryId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }

    public static ArrayList<Task> indexTasks(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from tasks where user_id = ?";

            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();

            ArrayList<Task> tasks = new ArrayList<>();
            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("place"),
                        rs.getFloat("importance"),
                        rs.getString("memo"),
                        rs.getTimestamp("due_at"),
                        null,
                        null,
                        0,
                        null,
                        null
                );
                tasks.add(task);
            }
            return tasks;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}