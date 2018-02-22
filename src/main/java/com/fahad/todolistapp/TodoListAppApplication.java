package com.fahad.todolistapp;

import com.fahad.todolistapp.models.TodoItem;
import com.fahad.todolistapp.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListAppApplication implements CommandLineRunner {

    @Autowired
    private TodoItemRepository todoItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoListAppApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        todoItemRepository.deleteAll();

        todoItemRepository.save(new TodoItem("Task 1", "This is task 1", true));
        todoItemRepository.save(new TodoItem("Task 2", "This is task 2", false));
        todoItemRepository.save(new TodoItem("Task 3", "This is task 3", true));

        for(TodoItem todoItem : todoItemRepository.findAll()){
            System.out.println(todoItem);
        }
    }
}
