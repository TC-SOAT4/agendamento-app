package com.fiap.agendamento.domain.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Agendamento {
    private UUID idAgendamento;
    private UUID idMedico;
    private UUID idPaciente;
    private Long idHorario;
    private StatusAgendamento status;
    private String observacao;
    private LocalDate dia;
    private LocalTime inicio;
    private LocalTime fim;
}
