package com.application.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoServlet
 */

@WebServlet("/add-todo.do")
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoService todoService = new TodoService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("WEB-INF/views/add-todo.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newTodo = request.getParameter("todo");
		String category = request.getParameter("category");
		todoService.addTodo(new Todo(newTodo, category));
		response.sendRedirect("/list-todos.do");
	}
	
}
