package com.geekster.todo.controller;

import com.geekster.todo.model.ToDo;
import com.geekster.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@RestController
@RequestMapping("/todo-app")
public class TodoController {
    @Autowired
     TodoService todoService;


    @GetMapping("/get-todo")
    public List<ToDo> getTodoTasks() {
     return todoService.findAll();
    }
     //http://localhost:8080/todo-app/add-todo
    @PostMapping("/add-todo")
    public void add(@RequestBody ToDo todo){
       todoService.addTodo(todo);
    }
    @DeleteMapping("/delete-todo/id/{id}")
    public void delete(@PathVariable int id){
        todoService.deleteTodo(id);
    }
    @PutMapping("/update-todo/id/{id}")
    public void update(@PathVariable int id,@RequestBody ToDo todo){
        todoService.updateTodo(id,todo);
    }
    @GetMapping("/find-by/id/{id}")
    public ToDo findTodoById(@PathVariable int id){
      return  todoService.findById(id);
    }

}
