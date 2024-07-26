package com.fiap.agendamento.infra.persistence.entity;

import com.fiap.agendamento.domain.entity.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Agendamento")
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAgendamento;
    private UUID idAgenda;
    private UUID idMedico;
    private UUID idPaciente;
    private Long idHorario;
    private StatusAgendamento status;
    private String observacao;
}
