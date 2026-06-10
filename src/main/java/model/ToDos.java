package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToDos {

	// 🔹 Get all tasks
	public List<ToDo> getAllToDo(int id) {
		List<ToDo> list = new ArrayList<>();

		try {
			System.out.println(id);

			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tasks WHERE user_id = ? ORDER BY status");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ToDo t = new ToDo();
				t.setId(rs.getInt("id"));
				t.setTitle(rs.getString("title"));
				t.setStatus(rs.getString("status"));
				list.add(t);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 🔹 Add a new task
	public void addToDo(ToDo task) {
		String sql = "INSERT INTO tasks (user_id, title, status) VALUES (?, ?, ?)";

		try {
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, task.getUserId());
			ps.setString(2, task.getTitle());
			ps.setString(3, task.getStatus());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 🔹 Delete task
	public void deleteToDo(int id) {
		String sql = "DELETE FROM tasks WHERE id = ?";

		try {
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 🔹 Update task status
	public void setToDoStatus(int id, String status) {
		String sql = "UPDATE tasks SET status = ? WHERE id = ?";

		try {
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, status);
			ps.setInt(2, id);

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}