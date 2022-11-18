package com.nttdata.escola.service;

import com.nttdata.escola.model.Login;
import com.nttdata.escola.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;

    public Optional<Login> findById(String username) {
        return repo.findById(username);
    }
}
