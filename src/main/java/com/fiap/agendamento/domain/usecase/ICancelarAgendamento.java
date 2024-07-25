package com.fiap.agendamento.domain.usecase;

import java.util.UUID;

public interface ICancelarAgendamento {

    public void executar(UUID agendamentoId);
}
