package com.nttdata.escola.validatores;

import com.nttdata.escola.model.Aluno;
import com.nttdata.escola.service.AlunoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

@Component
public class AlunoValidator {

    private AlunoService service;

    WebClient webClient = WebClient.builder ()
            .baseUrl ("http://localhost:8082")
            .defaultHeader (HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables (Collections.singletonMap ("url", "http://localhost:8082"))
            .clientConnector (new ReactorClientHttpConnector(HttpClient.create (ConnectionProvider.newConnection ())))
            .build ();

    public boolean validarAluno(Aluno aluno)  {

        aluno = webClient.post().uri("/getAluno/" + aluno).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(aluno)).retrieve().bodyToMono(Aluno.class).block();

        if (aluno != null){
            return true;
        }

        return false;
    }
}
