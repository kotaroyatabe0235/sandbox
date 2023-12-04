package com.example.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private boolean completed;

  public Todo() {
    super(); 
  }

  public Todo(String title) {
    this();
    this.title = title; 
  }
  
  public void setTitle(String title) {
    this.title = title;  
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public String getTitle() {
    return this.title; 
  }
  
  public boolean getCompleted() {
    return this.completed; 
  }

}
