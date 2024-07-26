package com.fiap.agendamento.domain.usecase;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.application.controller.dto.NovoAgendamentoDto;

public interface ICadastrarAgendamento {

    public AgendamentoResponse executar(NovoAgendamentoDto novoAgendamentoDto);

}
