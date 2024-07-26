package com.fiap.agendamento.application.usecase;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.application.controller.dto.NovoAgendamentoDto;
import com.fiap.agendamento.domain.entity.Agendamento;
import com.fiap.agendamento.domain.entity.StatusAgendamento;
import com.fiap.agendamento.domain.gateway.IAgendamentoGateway;
import com.fiap.agendamento.domain.usecase.ICadastrarAgendamento;
import com.fiap.agendamento.infra.persistence.mapper.AgendamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarAgendamento implements ICadastrarAgendamento {
    private final IAgendamentoGateway agendamentoGateway;
    private final AgendamentoMapper agendamentoMapper;

    @Override
    public AgendamentoResponse executar(NovoAgendamentoDto novoAgendamentoDto) {
        Agendamento agendamento = agendamentoMapper.toAgendamento(novoAgendamentoDto);
        agendamento.setStatus(StatusAgendamento.ABERTO);
        Agendamento agendamentoSalvo = agendamentoGateway.salvar(agendamento);
        AgendamentoResponse response = agendamentoMapper.toAgendamentoResponse(agendamentoSalvo);
        response.setIdAgendamento(agendamentoSalvo.getIdAgendamento().toString());

        return response;
    }
}
