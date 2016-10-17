package com.autoservice.repo;

import com.autoservice.model.Contractor;
import com.autoservice.model.TypeService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
public interface ContractorRepository extends CrudRepository<Contractor, Long> {

}
