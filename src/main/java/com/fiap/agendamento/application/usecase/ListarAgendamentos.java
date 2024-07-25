package com.fiap.agendamento.application.usecase;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.domain.gateway.IAgendamentoGateway;
import com.fiap.agendamento.domain.usecase.IListarAgendamentos;
import com.fiap.agendamento.infra.persistence.mapper.AgendamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarAgendamentos implements IListarAgendamentos {

    private final IAgendamentoGateway agendamentoGateway;

    private final AgendamentoMapper agendamentoMapper;

    @Override
    public List<AgendamentoResponse> executar() {
        return agendamentoMapper.toAgendamentoResponseList(agendamentoGateway.listarTodos());
    }
}
