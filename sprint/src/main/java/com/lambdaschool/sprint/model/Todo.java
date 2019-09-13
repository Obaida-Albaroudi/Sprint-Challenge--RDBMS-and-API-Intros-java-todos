package com.lambdaschool.sprint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Todoid;

    @Column(nullable = false)
    private String Todo;

    private String datestarted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties({"todos", "hibernateLazyInitializer"})
    private User user;

    public Todo()
    {
    }

    public Todo(String Todo, Object datestarted, User user)
    {
        this.Todo = Todo;
        this.datestarted = datestarted.toString();
        this.user = user;
    }

    public long getTodoid() {
        return Todoid;
    }

    public void setTodoid(long todoid) {
        Todoid = todoid;
    }

    public String getTodo() {
        return Todo;
    }

    public void setTodo(String todo) {
        Todo = todo;
    }

    public String getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(String datestarted) {
        this.datestarted = datestarted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}