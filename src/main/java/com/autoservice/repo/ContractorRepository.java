package com.autoservice.repo;

import com.autoservice.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
public interface ContractorRepository extends CrudRepository<Contractor, Long> {
    List<Contractor> findByTypeServices(@Param("typeServices") TypeService typeServices);
    List<Contractor> findByTypeVehicles(@Param("typeVehicles") TypeVehicle typeVehicles);
    List<Contractor> findByRangeworks(@Param("rangeworks") Rangeworks rangeworks);
    List<Contractor> findByCarmanufacture(@Param("rangeworks") Carmanufacture carmanufacture);
    List<Contractor> findByAddress(@Param("address") Address address);
    List<Contractor> findByEmail(@Param("email")String email);



}
