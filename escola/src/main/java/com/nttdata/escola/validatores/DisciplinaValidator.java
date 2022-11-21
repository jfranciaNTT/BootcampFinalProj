package com.nttdata.escola.validatores;

import com.nttdata.escola.model.Aluno;
import com.nttdata.escola.model.Disciplina;
import com.nttdata.escola.service.DisciplinaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.Collections;
import java.util.List;

@Component
public class DisciplinaValidator {

    private DisciplinaService service;

    WebClient webClient = WebClient.builder ()
            .baseUrl ("http://localhost:8082")
            .defaultHeader (HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables (Collections.singletonMap ("url", "http://localhost:8082"))
            .clientConnector (new ReactorClientHttpConnector(HttpClient.create (ConnectionProvider.newConnection ())))
            .build ();

    public boolean validarAluno(Disciplina disciplina)  {

        disciplina = webClient.post().uri("/postDisciplina/").contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(disciplina)).retrieve().bodyToMono(Disciplina.class).block();

        if (disciplina != null){
            return true;
        }

        return false;
    }
}
