package com.fiap.agendamento.application.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fiap.agendamento.domain.entity.StatusAgendamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AgendamentoResponse {
    private String idAgendamento;
    private String idMedico;
    private String idPaciente;
    private Long idHorario;
    private StatusAgendamento status;
    private String observacao;
    private LocalDate dia;
    private LocalTime inicio;
    private LocalTime fim;
}
