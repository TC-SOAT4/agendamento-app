package com.fiap.agendamento.application.usecase;

import com.fiap.agendamento.domain.client.IAgendaAppClient;
import com.fiap.agendamento.domain.entity.Agendamento;
import com.fiap.agendamento.domain.gateway.IAgendamentoGateway;
import com.fiap.agendamento.domain.usecase.IConfirmarAgendamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ConfirmarAgendamento implements IConfirmarAgendamento {

    private final IAgendamentoGateway agendamentoGateway;
    private final IAgendaAppClient agendaAppClient;

    @Override
    public void executar(UUID agendamentoId, String bearerToken) {
        Agendamento agendamento = agendamentoGateway.buscarPorId(agendamentoId);
        agendamentoGateway.confirmarAgendamento(agendamentoId);
        agendaAppClient.confirmarAgendamento(agendamento.getIdAgenda(), agendamento.getIdHorario(), bearerToken);
    }

}
