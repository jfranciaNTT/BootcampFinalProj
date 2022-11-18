package com.nttdata.escola.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disciplinaId;
    private String nomeDisciplina;
    private String area;

    public Disciplina(Long id, String nome, String area) {
        this.disciplinaId = id;
        this.nomeDisciplina = nome;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + disciplinaId +
                ", nome='" + nomeDisciplina + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
