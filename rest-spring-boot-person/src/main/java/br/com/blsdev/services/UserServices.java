package br.com.blsdev.services;

import br.com.blsdev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var user = repository.findByUsername(userName);
        if (user != null) {
            return user;
        } else {
            throw new  UsernameNotFoundException("User name " + userName + " not found!");
        }
    }
}
