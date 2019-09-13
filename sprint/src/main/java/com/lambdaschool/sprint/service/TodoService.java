package com.lambdaschool.sprint.service;

import com.lambdaschool.sprint.model.Todo;


import java.util.ArrayList;
import java.util.List;

public interface TodoService
{
    List<Todo> findAll();

    Todo findTodoById(long id);

    List<Todo> findByUserName(String username);

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);

}
