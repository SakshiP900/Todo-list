package com.application.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoService todoService = new TodoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		todoService.deleteTodo(new Todo(request.getParameter("todo"), request.getParameter("catgory")));
		response.sendRedirect("/list-todos.do");
	}	

}
