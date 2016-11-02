package com.autoservice.configuration;

import com.autoservice.model.Client;
import com.autoservice.service.ClientService;
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
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientService.getClientByMail(username);
        System.out.println("User : "+client);
        if(client==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(client.getEmail(), client.getPassword(), getGrantedAuthorities(client));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Client client){
        List<GrantedAuthority> authorities = new ArrayList<>();
        // TODO: Roles
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

}
