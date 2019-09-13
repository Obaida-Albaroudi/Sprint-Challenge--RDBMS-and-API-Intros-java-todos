package com.lambdaschool.sprint.repository;

import com.lambdaschool.sprint.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TodoRepository extends CrudRepository<Todo, Long>
{
//    @Query(value = "SELECT u.username as username, COUNT(*) as countquotes FROM quotes q JOIN users u ON q.userid = u.userid GROUP BY u.username", nativeQuery = true)

}
