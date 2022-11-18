package com.nttdata.ministerio_educacao.repository;

import com.nttdata.ministerio_educacao.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
