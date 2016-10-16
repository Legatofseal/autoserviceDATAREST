package com.autoservice.repo;

import com.autoservice.model.Client;
import com.autoservice.model.Comment;
import com.autoservice.model.Contractor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findByClient(@Param("client") Client client);

    List<Comment> findByContractor(@Param("contractor") Contractor contractor);
    List<Comment> findAll();
}
