package com.fiap.agendamento.application.usecase;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.application.controller.dto.NovoAgendamentoRequest;
import com.fiap.agendamento.domain.entity.Agendamento;
import com.fiap.agendamento.domain.entity.StatusAgendamento;
import com.fiap.agendamento.domain.gateway.IAgendamentoGateway;
import com.fiap.agendamento.domain.usecase.ICadastrarAgendamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CadastrarAgendamento implements ICadastrarAgendamento {

    private final IAgendamentoGateway agendamentoGateway;

    @Override
    public AgendamentoResponse executar(NovoAgendamentoRequest novoAgendamentoRequest) {
        Agendamento agendamento = Agendamento.builder()
                .horarioId(UUID.fromString(novoAgendamentoRequest.getHorarioId()))
                .pacienteId(UUID.fromString(novoAgendamentoRequest.getPacienteId()))
                .status(StatusAgendamento.ABERTO)
                .observacao(novoAgendamentoRequest.getObservacao())
                .build();

         var agendamentoSalvo = agendamentoGateway.salvar(agendamento);

        AgendamentoResponse response = AgendamentoResponse.builder()
                .horarioId(agendamento.getHorarioId().toString())
                .pacienteId(agendamento.getPacienteId().toString())
                .status(agendamento.getStatus())
                .observacao(agendamento.getObservacao())
                .build();

        response.setIdAgendamento(agendamentoSalvo.getIdAgendamento().toString());

        return response;
    }
}
