package com.autoservice.repo;

import com.autoservice.model.Client;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Legat on 9/27/2016.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

}
