package com.autoservice.repo;

import com.autoservice.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Legat on 9/27/2016.
 */
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
}
