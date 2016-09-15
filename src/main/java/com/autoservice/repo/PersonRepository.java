package com.autoservice.repo;

import com.autoservice.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long> {
    @RestResource(path = "byName")
    List findByPersonName(@Param("name") String personName);
}


