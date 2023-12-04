package com.example.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {
  @Autowired
  private TodoRepository todoRepository;

  @GetMapping
  public List<Todo> getTodos() {
    return todoRepository.findAll(); 
  }

  @PostMapping
  public Todo createTodo(@RequestBody Todo todo) {
    return todoRepository.save(todo);
  }

  @PutMapping("/{id}")
  public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
    Optional<Todo> optionialTodo = todoRepository.findById(id); 
    Todo existingTodo = optionialTodo.orElseThrow(() -> new RuntimeException()); 		  
    existingTodo.setTitle(todo.getTitle());  
    existingTodo. setCompleted(todo.getCompleted());
    return todoRepository.save(existingTodo);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
    Todo existingTodo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException());
    todoRepository.delete(existingTodo);
    return ResponseEntity.ok().build();
  }

}
