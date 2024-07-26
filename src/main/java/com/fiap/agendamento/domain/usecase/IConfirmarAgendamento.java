package com.fiap.agendamento.domain.usecase;

import java.util.UUID;

public interface IConfirmarAgendamento {

    public void executar(UUID agendamentoId);
}
