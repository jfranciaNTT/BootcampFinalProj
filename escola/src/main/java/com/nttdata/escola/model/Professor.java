package com.nttdata.escola.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
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

    public Professor(Long nif, String nome, Integer idade, Integer tempoEnsino, Double salario, Disciplina disciplinaId) {
        this.nifProfessor = nif;
        this.nomeProfessor = nome;
        this.idadeProfessor = idade;
        this.tempoEnsino = tempoEnsino;
        this.salario = salario;
        this.disciplinaId = disciplinaId;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nif=" + nifProfessor +
                ", nome='" + nomeProfessor + '\'' +
                ", idade=" + idadeProfessor +
                ", tempoEnsino=" + tempoEnsino +
                ", salario=" + salario +
                ", disciplinaId=" + disciplinaId +
                '}';
    }
}
