package com.autoservice.repo;

import com.autoservice.model.UserAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Legat on 11/2/2016.
 */
public interface UserauthRepository extends CrudRepository<UserAuth, Long> {
   UserAuth findByEmail(@Param("email") String email);
}
