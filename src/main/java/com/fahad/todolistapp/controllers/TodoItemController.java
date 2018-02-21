package com.fahad.todolistapp.controllers;

import com.fahad.todolistapp.models.TodoItem;
import com.fahad.todolistapp.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fahad Ahmed
 */
@RestController
@RequestMapping("/api/todoitems")
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping()
    public void getAll(){
        List<TodoItem> todoItems = new ArrayList<TodoItem>();
        for(TodoItem todoItem : todoItemRepository.findAll()){
            todoItems.add(todoItem);
        }
    }

    @GetMapping("/by-id/{id}")
    public TodoItem getById(long id){
        return todoItemRepository.findById(id);
    }

    @GetMapping("/by-title/{id}")
    public TodoItem getByTitle(String title){
        return todoItemRepository.findByTitle(title);
    }
}