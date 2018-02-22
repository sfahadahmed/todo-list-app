package com.fahad.todolistapp.repositories;

import com.fahad.todolistapp.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fahad Ahmed
 */
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    TodoItem findById(long id);
    TodoItem findByTitle(String title);
}
