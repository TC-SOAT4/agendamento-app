package com.fiap.agendamento.infra.listeners;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FilaAgendamentoDto {

    private UUID idMedico;
    private UUID idPaciente;
    private Long idHorario;
    private LocalTime inicio;
    private LocalTime fim;
    private LocalDate dia;
    
    
}
