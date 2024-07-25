package com.fiap.agendamento.application.controller.dto;

import com.fiap.agendamento.domain.entity.StatusAgendamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AgendamentoResponse {
    private String idAgendamento;
    private String pacienteId;
    private String horarioId;
    private StatusAgendamento status;
    private String observacao;
}
