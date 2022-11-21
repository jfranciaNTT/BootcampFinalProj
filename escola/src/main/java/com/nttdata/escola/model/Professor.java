package com.nttdata.escola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Entity
@Table(name = "professor")
public class Professor {

    @Id
    private Long nifProfessor;
    private String nomeProfessor;
    private Integer idadeProfessor;
    private Integer tempoEnsino;
    private Double salario;
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplinaId;

    @Override
    public String toString() {
        return nomeProfessor;
    }
}
