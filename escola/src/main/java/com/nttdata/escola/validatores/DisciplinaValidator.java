package com.nttdata.escola.validatores;

import com.nttdata.escola.model.Disciplina;
import com.nttdata.escola.service.DisciplinaService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class DisciplinaValidator {

    private DisciplinaService service;

    public void validarDisciplina(Disciplina disciplina) {
        WebClient webClient = WebClient.create("http://localhost:8082");
        List<Disciplina> disciplinaList = webClient.get().uri("/disciplina")
                .retrieve().bodyToFlux(Disciplina.class).collectList().block();
    }
}
