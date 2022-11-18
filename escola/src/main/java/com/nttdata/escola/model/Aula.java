package com.nttdata.escola.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aulaId;
    @ManyToOne
    @JoinColumn(name = "professor_nif")
    private Professor professorNif;
    @ManyToOne
    @JoinColumn(name = "aluno_nif")
    private Aluno alunoNif;
    private Date data;
    private Double duracao;

    public Aula(Long id, Professor professorNif, Aluno alunoNif, Date data, Double duracao) {
        this.aulaId = id;
        this.professorNif = professorNif;
        this.alunoNif = alunoNif;
        this.data = data;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + aulaId +
                ", professorNif=" + professorNif +
                ", alunoNif=" + alunoNif +
                ", data=" + data +
                ", duracao=" + duracao +
                '}';
    }
}
