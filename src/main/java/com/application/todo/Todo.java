package com.application.todo;

import java.util.Objects;

public class Todo {
	
	private String nameString;
	private String category;
	
	public Todo(String name, String category) {
		this.nameString = name;
		this.category = category;
	}
	
	public void setName(String name) {
		this.nameString = name;
	}
	
	public String getName() {
		return nameString;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(category, nameString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(category, other.category) && Objects.equals(nameString, other.nameString);
	}

	@Override
	public String toString() {
		return "Todo -> Name: " + nameString + " Category: "+ category;
	}
	
}
