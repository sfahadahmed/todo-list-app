package com.fahad.todolistapp.repositories;

import com.fahad.todolistapp.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fahad Ahmed
 */
public interface TodoItemRepository extends CrudRepository <TodoItem, Long> {
    TodoItem findById(long id);
    TodoItem findByTitle(String title);
}
