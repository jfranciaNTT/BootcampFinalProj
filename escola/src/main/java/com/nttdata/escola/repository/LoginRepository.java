package com.nttdata.escola.repository;

import com.nttdata.escola.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> {
}
