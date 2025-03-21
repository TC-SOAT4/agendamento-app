package com.fiap.agendamento.application.usecase;

import com.fiap.agendamento.domain.gateway.IAgendamentoGateway;
import com.fiap.agendamento.domain.usecase.ICancelarAgendamento;
import com.fiap.agendamento.infra.persistence.mapper.AgendamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CancelarAgendamento implements ICancelarAgendamento {

    private final IAgendamentoGateway agendamentoGateway;

    private final AgendamentoMapper agendamentoMapper;

    @Override
    public void executar(UUID agendamentoId) {
        agendamentoGateway.cancelarAgendamento(agendamentoId);
    }
}
