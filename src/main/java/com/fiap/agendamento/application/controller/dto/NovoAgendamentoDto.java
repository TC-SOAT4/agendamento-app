package com.fiap.agendamento.application.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class NovoAgendamentoDto {
    private UUID idAgenda;
    private UUID idMedico;
    private UUID idPaciente;
    private Long idHorario;
    private String observacao;
}
