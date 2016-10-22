package com.autoservice.repo;

import com.autoservice.model.Phone;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Legat on 10/21/2016.
 */
public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
