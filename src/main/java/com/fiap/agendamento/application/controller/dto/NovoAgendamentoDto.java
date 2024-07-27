package com.fiap.agendamento.application.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Builder
public class NovoAgendamentoDto {
    private UUID idMedico;
    private UUID idPaciente;
    private Long idHorario;
    private String observacao;
    private LocalDate dia;
    private LocalTime inicio;
    private LocalTime fim;
}
