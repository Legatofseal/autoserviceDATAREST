package com.autoservice.repo;

import com.autoservice.model.Client;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Legat on 9/27/2016.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByEmail(@Param("email") String email);

    Client findByEmailAndPassword(@Param("email") String email, @Param("password")String password);
    @Transactional
    void deleteByEmail(@Param("email")String email);


}
