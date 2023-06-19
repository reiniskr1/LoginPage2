package com.reiniskr.html.repo;


import com.reiniskr.html.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(int Id);
    List<User> findAll();
    void deleteById(int Id);


}
