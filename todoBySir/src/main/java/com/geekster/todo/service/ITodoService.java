package com.geekster.todo.service;

import com.geekster.todo.model.ToDo;

import java.util.List;

public interface ITodoService {
 List<ToDo> findAll();
     ToDo findById(int id);
    void addTodo(ToDo todo);
    void deleteTodo(int id);
    void updateTodo(int id,ToDo newtodo);
}
