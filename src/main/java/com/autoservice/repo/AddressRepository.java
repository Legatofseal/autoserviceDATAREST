package com.autoservice.repo;

import com.autoservice.model.Address;
import com.autoservice.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Legat on 9/27/2016.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findByArea(@Param("area") String area);
    List<Address> findByAreaAndCity(@Param("area") String area,@Param("city") String city);
}
