package com.lambdaschool.sprint.repository;

import com.lambdaschool.sprint.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
