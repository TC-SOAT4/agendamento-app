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
    private UUID pacienteId;
    private UUID horarioId;
    private StatusAgendamento status;
    private String observacao;
}
