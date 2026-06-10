package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dbConnection;

@WebServlet("/registeration")
public class RegisterationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		Connection conn = null;
		try {
			conn = dbConnection.getConnection();
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				out.println("<p style='color:red'>username not available</p>");
			} else {
				String insert_sql = "INSERT INTO users(name,username,email,password_hash) VALUES(?,?,?,?)";
				PreparedStatement in = conn.prepareStatement(insert_sql);
				in.setString(1, name);
				in.setString(2, userName);
				in.setString(3, email);
				in.setString(4, password);
				int rowsAffected = in.executeUpdate();

				if (rowsAffected > 0) {
					out.println("<h3>Query successful, rows affected: </h3>" + rowsAffected);
					resp.sendRedirect("login.html");
				} else {
					out.println("<h3>No rows affected</h3>");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
