package unittest.fakeBusiness;

import java.util.ArrayList;
import java.util.List;

import unittest.fakeinterface.TodoService;

//class trên định nghĩa các phương thức xử lý tương tác với các interface
public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	// trả về chuỗi ko liên quan đến key
	public List<String> retrieveTodosRelatedToSpring(String key) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(key);
		// Loại bỏ chuỗi trong list không chứa "key"
		for (String todo : allTodos) {
			if (todo.contains(key)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	// xóa chuỗi ko liên quan đến key
	public void deleteTodosNotRelatedToSpring(String key) {
		List<String> allTodos = todoService.retrieveTodos(key);
		for (String todo : allTodos) {
			if (!todo.contains(key)) {
				todoService.deleteTodo(todo);
			}
		}
	}
}
