package com.autoservice.configuration;

import com.autoservice.model.Client;
import com.autoservice.model.UserAuth;
import com.autoservice.service.ClientService;
import com.autoservice.service.UserauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    ///private ClientService clientService;
    private UserauthService userauthService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAuth userAuth = userauthService.getByEmail(email);
      //  System.out.println("User : "+client);
        if(userAuth==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(userAuth.getEmail(), userAuth.getPassword(), getGrantedAuthorities(userAuth));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserAuth userAuth){
        List<GrantedAuthority> authorities = new ArrayList<>();
        // TODO: Roles
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));

        return authorities;
    }

}
