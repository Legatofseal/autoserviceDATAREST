package com.autoservice.repo;

import com.autoservice.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Legat on 9/27/2016.
 */
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {

    @Transactional
    void deleteById(@Param("id")Long id);
}
