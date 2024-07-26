package com.fiap.agendamento.infra.persistence.repository;

import com.fiap.agendamento.infra.persistence.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoEntityRepository extends JpaRepository<AgendamentoEntity, UUID> {

}
