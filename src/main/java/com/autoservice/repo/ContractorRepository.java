package com.autoservice.repo;

import com.autoservice.model.Contractor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Legat on 10/15/2016.
 */
public interface ContractorRepository extends CrudRepository<Contractor, Long> {
}
