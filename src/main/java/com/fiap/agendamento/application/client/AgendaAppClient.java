package com.fiap.agendamento.application.client;

import com.fiap.agendamento.domain.client.IAgendaAppClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AgendaAppClient implements IAgendaAppClient {

    private final RestTemplate restTemplate;

    @Value("${uri.api.agenda}")
    private String uri;

    @Override
    public void confirmarAgendamento(UUID idAgenda, Long idHorario, String bearerToken) {
        String urlWithParams = String.format(uri + "/api/agendas/%s/horarios/%d", idAgenda, idHorario);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization", bearerToken);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(urlWithParams, HttpMethod.POST, requestEntity, String.class);
    }

    @Override
    public void cancelarAgendamento(UUID idAgenda, Long idHorario, String bearerToken) {
        String urlWithParams = String.format(uri + "/api/agendas/%s/horarios/%d", idAgenda, idHorario);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization", bearerToken);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(urlWithParams, HttpMethod.POST, requestEntity, String.class);
    }
}
