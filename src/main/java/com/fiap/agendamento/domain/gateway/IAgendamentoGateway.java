package com.fiap.agendamento.domain.gateway;

import com.fiap.agendamento.domain.entity.Agendamento;

import java.util.List;
import java.util.UUID;

public interface IAgendamentoGateway {

    public Agendamento buscarPorId(UUID agendamentoId);

    public Agendamento salvar(Agendamento agendamento);

    public void confirmarAgendamento(UUID agendamentoId);

    public void cancelarAgendamento(UUID agendamentoId);

    public List<Agendamento> listarTodos();

}
