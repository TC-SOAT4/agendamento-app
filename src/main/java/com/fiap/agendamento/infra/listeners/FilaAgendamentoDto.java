package com.fiap.agendamento.infra.listeners;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class FilaAgendamentoDto {
    private UUID idMedico;
    private UUID idPaciente;
    private LocalDate dia;
    private LocalTime inicio;
    private LocalTime fim;
    private UUID idHorario;
}
