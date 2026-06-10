package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ToDo;
import model.ToDos;

@WebServlet("/todo")
public class ToDoServlet extends HttpServlet {
	private ToDos op = new ToDos();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("userId") == null) {
			response.sendRedirect("login.html");
			return;
		}

		int userId = (int) session.getAttribute("userId");

		String action = request.getParameter("action");

		if ("add".equals(action)) {
			String title = request.getParameter("title");
			String status = request.getParameter("status");

			ToDo task = new ToDo();
			task.setTitle(title);
			task.setStatus(status);
			task.setUserId(userId); //

			op.addToDo(task);

		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			op.deleteToDo(id);
		} else if ("updateStatus".equals(action)) {

			int id = Integer.parseInt(request.getParameter("id"));
			String status = request.getParameter("status");

			op.setToDoStatus(id, status);
		}

		response.sendRedirect("todo");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			resp.sendRedirect("/login.html");
			return;
		}
		String username = (String) session.getAttribute("username");
		int uid = (int) session.getAttribute("userId");
		req.setAttribute("username", username);

		List<ToDo> tasks = op.getAllToDo(uid);

		req.setAttribute("taskList", tasks);

		RequestDispatcher rd = req.getRequestDispatcher("tasks.jsp");
		rd.forward(req, resp);
	}
}