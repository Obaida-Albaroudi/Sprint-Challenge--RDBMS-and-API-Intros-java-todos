package com.lambdaschool.sprint.controller;

import com.lambdaschool.sprint.model.Todo;
import com.lambdaschool.sprint.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodosController
{
    @Autowired
    TodoService todoService;

    @GetMapping(value = "/todos",
                produces = {"application/json"})
    public ResponseEntity<?> listAllTodos()
    {
        List<Todo> allQuotes = todoService.findAll();
        return new ResponseEntity<>(allQuotes, HttpStatus.OK);
    }


    @GetMapping(value = "/todo/{todoId}",
                produces = {"application/json"})
    public ResponseEntity<?> getTodo(
            @PathVariable
                    Long Todoid)
    {
        Todo t = todoService.findTodoById(Todoid);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @GetMapping(value = "/username/{userName}",
                produces = {"application/json"})
    public ResponseEntity<?> findIdByUsernames(
            @PathVariable
                    String userName)
    {
        List<Todo> theTodos = todoService.findByUserName(userName);
        return new ResponseEntity<>(theTodos, HttpStatus.OK);
    }


    @PostMapping(value = "/todo")
    public ResponseEntity<?> addNewQuote(@Valid
                                         @RequestBody
                                                 Todo newTodo) throws URISyntaxException
    {
        newTodo = todoService.save(newTodo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newQuoteURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Todoid}").buildAndExpand(newTodo.getTodoid()).toUri();
        responseHeaders.setLocation(newQuoteURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/todo/{Todoid}")
    public ResponseEntity<?> updateQuote(
            @RequestBody
                    Todo updateTodo,
            @PathVariable
                    long Todoid)
    {
        todoService.update(updateTodo, Todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteQuoteById(
            @PathVariable
                    long id)
    {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
