package com.fiap.agendamento.domain.usecase;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.application.controller.dto.NovoAgendamentoRequest;

public interface ICadastrarAgendamento {

    public AgendamentoResponse executar(NovoAgendamentoRequest novoAgendamentoRequest);

}
