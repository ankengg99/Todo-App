package com.geekster.todo.service;

import com.geekster.todo.TodoApplication;
import com.geekster.todo.model.ToDo;
import com.geekster.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
@Service
public class TodoService implements ITodoService {


@Autowired
    TodoRepository todoRepository;
    @Override
        public List<ToDo> findAll(){
        return todoRepository.findAll();
        }
        public ToDo findById(int id)throws NoSuchElementException {
          return todoRepository.findById(id).get();
        }

        @Override
        public void addTodo(ToDo todo){
         todoRepository.save(todo);
        }

        @Override
        public  void deleteTodo(int id){
           todoRepository.deleteById(id);
        }

        @Override
        public void updateTodo(int id,ToDo newtodo){
        ToDo temp=todoRepository.findById(id).get();
        temp.setId(newtodo.getId());
        temp.setTitle(newtodo.getTitle());
        temp.setStatus(newtodo.isStatus());
        todoRepository.save(temp);
        }
}
