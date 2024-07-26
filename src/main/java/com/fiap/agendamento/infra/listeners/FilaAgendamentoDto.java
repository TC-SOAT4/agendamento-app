package com.fiap.agendamento.infra.listeners;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FilaAgendamentoDto {
    private UUID idMedico;
    private UUID idPaciente;
    private Long idHorario;
}
