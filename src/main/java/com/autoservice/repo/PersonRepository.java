package com.autoservice.repo;

import com.autoservice.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@SuppressWarnings("unused")
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByPersonName(@Param("personName") String personName);
    List<Person> findByPersonAge(@Param("personAge") double age);
}


