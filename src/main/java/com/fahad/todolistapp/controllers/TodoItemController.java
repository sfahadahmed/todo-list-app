package com.fahad.todolistapp.controllers;

import com.fahad.todolistapp.models.TodoItem;
import com.fahad.todolistapp.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Fahad Ahmed
 */
@RestController
@RequestMapping("/api/todoitems")
@CrossOrigin(origins = "*")
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping()
    public List<TodoItem> getAll(){
        List<TodoItem> todoItems = new ArrayList<TodoItem>();
        for(TodoItem todoItem : todoItemRepository.findAll()){
            todoItems.add(todoItem);
        }

        return todoItems;
    }

    @GetMapping("/{id}")
    public TodoItem getById(@PathVariable long id){
        Optional<TodoItem> todoItem = Optional.ofNullable(todoItemRepository.findById(id));
        return todoItem.get();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody TodoItem todoItem){
        TodoItem savedTodoItem = todoItemRepository.save(todoItem);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedTodoItem.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody TodoItem todoItem){
        Optional<TodoItem> savedTodoItem = Optional.ofNullable(todoItemRepository.findById(id));

        if(!savedTodoItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        else {
            todoItem.setId(id);
            todoItemRepository.save(todoItem);

            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        todoItemRepository.delete(id);
    }
}
