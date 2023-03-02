package com.example.todolist.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.todolist.entity.Todo;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoRepositoryTest {

  @Autowired
  TodoRepository todoRepository;

  @Test
  @Transactional
  @Rollback
  public void testCreate() {
    Todo data = new Todo();
    data.setTitle("TEST");
    data.setCompleted(false);

    todoRepository.save(data);
  
    List<Todo> result = todoRepository.findAll();
    assertEquals(result.size(),1,"OK"); 
  }

  @Test
  @Transactional
  @Rollback
  public void testUpdate() {
    Todo data = new Todo();
    data.setTitle("TEST");
    data.setCompleted(false);
    todoRepository.save(data);
 
    data.setTitle("TEST2");
    todoRepository.save(data);

    List<Todo> result = todoRepository.findAll();

    assertEquals(result.size(),1,"OK");
    assertEquals(result.get(0).getTitle(),"TEST2");
  }
  
}
