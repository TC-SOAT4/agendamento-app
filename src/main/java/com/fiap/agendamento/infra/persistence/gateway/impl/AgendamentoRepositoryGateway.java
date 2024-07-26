package com.fiap.agendamento.infra.persistence.gateway.impl;

import com.fiap.agendamento.domain.entity.Agendamento;
import com.fiap.agendamento.domain.entity.StatusAgendamento;
import com.fiap.agendamento.domain.gateway.IAgendamentoGateway;
import com.fiap.agendamento.infra.persistence.entity.AgendamentoEntity;
import com.fiap.agendamento.infra.persistence.mapper.AgendamentoMapper;
import com.fiap.agendamento.infra.persistence.repository.AgendamentoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AgendamentoRepositoryGateway implements IAgendamentoGateway {

    private final AgendamentoEntityRepository agendamentoEntityRepository;

    private final AgendamentoMapper agendamentoMapper;

    @Override
    public List<Agendamento> listarTodos() {
        return agendamentoMapper.toAgendamentoList(agendamentoEntityRepository.findAll());
    }

    @Override
    public Agendamento buscarPorId(UUID agendamentoId) {
        AgendamentoEntity agendamentoEntity = agendamentoEntityRepository.findById(agendamentoId)
                .orElseThrow(() -> new RuntimeException(String.format("Agendamento com ID %s nao existe.", agendamentoId)));

        return agendamentoMapper.toAgendamento(agendamentoEntity);
    }

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        AgendamentoEntity agendamentoEntity = agendamentoMapper.toAgendamentoEntity(agendamento);
        AgendamentoEntity response = agendamentoEntityRepository.save(agendamentoEntity);

        return agendamentoMapper.toAgendamento(response);
    }

    @Override
    public void confirmarAgendamento(UUID agendamentoId) {
        AgendamentoEntity agendamentoEntity = agendamentoEntityRepository.findById(agendamentoId)
                .orElseThrow(() -> new RuntimeException(String.format("Agendamento com ID %s nao existe.", agendamentoId)));

        agendamentoEntity.setStatus(StatusAgendamento.CONFIRMADO);

        agendamentoEntityRepository.save(agendamentoEntity);
    }

    @Override
    public void cancelarAgendamento(UUID agendamentoId) {
        AgendamentoEntity agendamentoEntity = agendamentoEntityRepository.findById(agendamentoId)
                .orElseThrow(() -> new RuntimeException(String.format("Agendamento com ID %s nao existe.", agendamentoId)));

        agendamentoEntity.setStatus(StatusAgendamento.CANCELADO);

        agendamentoEntityRepository.save(agendamentoEntity);
    }

}
