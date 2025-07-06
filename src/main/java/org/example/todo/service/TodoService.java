package org.example.todo.service;

import org.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final List<Todo> todos = new ArrayList<>();
    private int nextId = 1;

    public List<Todo> getAll() {
        return todos;
    }

    public Todo add(Todo todo) {
        todo.setId(nextId++);
        todos.add(todo);
        return todo;
    }

    public Todo update(int id, Todo updated) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setTask(updated.getTask());
                todo.setCompleted(updated.isCompleted());
                return todo;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        return todos.removeIf(t -> t.getId() == id);
    }
}
