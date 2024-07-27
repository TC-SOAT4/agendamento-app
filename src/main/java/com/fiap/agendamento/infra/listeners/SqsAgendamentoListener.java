package com.fiap.agendamento.infra.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiap.agendamento.application.controller.dto.NovoAgendamentoDto;
import com.fiap.agendamento.application.usecase.CadastrarAgendamento;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "receber.agendamento.enabled", havingValue = "true", matchIfMissing = false)
@RequiredArgsConstructor
@Component
public class SqsAgendamentoListener {
    private final CadastrarAgendamento cadastrarAgendamento;

    @SqsListener("${aws.sqs.name}")
    public void receiveMessage(String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        FilaAgendamentoDto filaAgendamentoDto = objectMapper.readValue(json, FilaAgendamentoDto.class);

        NovoAgendamentoDto novoAgendamentoDto = NovoAgendamentoDto.builder()
                .idMedico(filaAgendamentoDto.getIdMedico())
                .idPaciente(filaAgendamentoDto.getIdPaciente())
                .idHorario(filaAgendamentoDto.getIdHorario())
                .dia(filaAgendamentoDto.getDia())
                .inicio(filaAgendamentoDto.getInicio())
                .fim(filaAgendamentoDto.getFim())
                .build();

        cadastrarAgendamento.executar(novoAgendamentoDto);
    }

}
