package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.todo.repository.TodoRepository;

@RestController
public class TodoJpaResource {

//private TodoService todoService ; 
	private TodoRepository todoRepository;

	public TodoJpaResource(TodoRepository todoRepository) {
		this.todoRepository = todoRepository; 
	}

	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {
		//return todoService.findByUsername(username); 
		return todoRepository.findByUsername(username); 
	}

	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
	//return todoService.findById(id);
	Optional<Todo> todoRetrieved  = todoRepository.findById(id); 
		if (todoRetrieved.isPresent()) 
			return todoRetrieved.get();
		else 
			return new Todo(0, "","", LocalDate.now(), false) ; 
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<?> removeTodo(@PathVariable String username, @PathVariable int id) {
//		todoService.deleteById(id);
		todoRepository.deleteById(id); 
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
//		todoService.updateTodo(todo);
		todoRepository.save(todo); 
		return todo;
	}

	@PostMapping("/users/{username}/todos")
	public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
//		Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		todo.setUsername(username); 
		todo.setId(null); 
		return todoRepository.save(todo); 
//		return createdTodo;
	}

}
