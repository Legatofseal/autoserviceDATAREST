package com.autoservice.service;

import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.model.UserAuth;
import com.autoservice.repo.UserauthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Legat on 11/2/2016.
 */
@Service
public class UserauthService {
    private final UserauthRepository userauthRepository;


    @Autowired
    public UserauthService(UserauthRepository userauthRepository) {
        this.userauthRepository = userauthRepository;
    }

    public UserAuth create(UserAuth userAuth) {

        if (userauthRepository.findByEmail(userAuth.getEmail()) != null) {
            throw new AlreadyExistsException("AlreadyExists", userAuth);

        }

        UserAuth result = userauthRepository.save(userAuth);
        return result;
    }

    public UserAuth getByEmail(String email) {
        return userauthRepository.findByEmail(email);
    }


    public void updatePassword(String email, String password) {

        UserAuth temp = userauthRepository.findByEmail(email);
        temp.setPassword(password);
        userauthRepository.save(temp);
    }

    public boolean checkPassword(String email, String password) {
        return (userauthRepository.findByEmail(email).getPassword().equals(password));

    }


}
