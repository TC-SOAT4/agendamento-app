package com.fiap.agendamento.application.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NovoAgendamentoRequest {
    private String pacienteId;
    private String horarioId;
    private String observacao;
}
