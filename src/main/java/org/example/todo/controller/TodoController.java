package org.example.todo.controller;

import org.example.todo.model.Todo;
import org.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> getTodos() {
        return service.getAll();
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.add(todo);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable int id, @RequestBody Todo todo) {
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.delete(id) ? "Deleted" : "Not Found";
    }
}
