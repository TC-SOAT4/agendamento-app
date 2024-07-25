package com.fiap.agendamento.domain.usecase;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;

import java.util.List;

public interface IListarAgendamentos {

    public List<AgendamentoResponse> executar();

}
