package com.nttdata.escola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;
    private Double duracao;

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
