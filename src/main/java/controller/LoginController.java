package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dbConnection;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		// out.println("<h1>Hello </h1>" + name + " <H3> </H3>" + password);
		Connection conn = null;
		try {
			conn = dbConnection.getConnection();
			String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				HttpSession session = request.getSession();
				session.setAttribute("username", name);
				session.setAttribute("userId", id);
				response.sendRedirect(request.getContextPath() + "/tasks.jsp");

			} else {
				request.setAttribute("errorMessage", "Invalid username or password!");
				request.getRequestDispatcher("login.html").forward(request, response);
			}
			conn.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.close();

	}
}
