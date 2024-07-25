package com.fiap.agendamento.domain.usecase;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;

import java.util.List;
import java.util.UUID;

public interface IConfirmarAgendamento {

    public void executar(UUID agendamentoId);
}
