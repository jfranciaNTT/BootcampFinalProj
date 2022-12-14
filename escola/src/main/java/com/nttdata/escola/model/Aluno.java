package com.nttdata.escola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {


    @Id
    private Long nif;
    private String nome;
    private Integer idade;
    private Integer escolaridade;


    @Override
    public String toString() {
        return nome;
    }
}
