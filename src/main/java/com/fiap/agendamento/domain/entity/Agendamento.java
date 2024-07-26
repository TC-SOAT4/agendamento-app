package com.fiap.agendamento.domain.entity;

import lombok.*;

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
    private UUID idHorario;
    private StatusAgendamento status;
    private String observacao;
}
