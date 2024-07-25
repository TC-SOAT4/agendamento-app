package com.fiap.agendamento.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.fiap.agendamento.infra.persistence.entity.AgendamentoEntity;

public interface AgendamentoEntityRepository extends JpaRepository<AgendamentoEntity, UUID> {

}
