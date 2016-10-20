package com.autoservice.repo;

import com.autoservice.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
public interface ContractorRepository extends CrudRepository<Contractor, Long> {
    List<Contractor> findByTypeServices(@Param("typeServices") TypeService typeServices);

    List<Contractor> findByRangeworks(@Param("rangeworks") Rangeworks rangeworks);
    List<Contractor> findByCarmanufacture(@Param("rangeworks") Carmanufacture carmanufacture);
}
