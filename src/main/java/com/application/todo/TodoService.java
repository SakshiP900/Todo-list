package com.application.todo;

import java.util.ArrayList;
import java.util.List;

import com.application.todo.Todo;

public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	static {
		todos.add(new Todo("Learn Web Application Development", "Study"));
		todos.add(new Todo("Learn Spring MVC", "Study"));
		todos.add(new Todo("Learn Spring REST Services", "Study"));
	}
	
	public List<Todo> retrieveTodos(){
		return todos;
	}
	
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
	public void deleteTodo(Todo todo) {
		todos.remove(todo);
	}

}
