package com.autoservice.repo;

import com.autoservice.model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Legat on 9/27/2016.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
