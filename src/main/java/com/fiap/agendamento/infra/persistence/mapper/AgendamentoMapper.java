package com.fiap.agendamento.infra.persistence.mapper;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.domain.entity.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.fiap.agendamento.infra.persistence.entity.AgendamentoEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AgendamentoMapper {

//    public Agendamento toAgendamento(NovoAgendamentoRequest novoAgendamentoRequest);
    public AgendamentoEntity toAgendamentoEntity(Agendamento agendamento);
    public Agendamento toAgendamento(AgendamentoEntity agendamentoEntity);
//    public AgendamentoResponse toAgendamentoResponse(Agendamento agendamento);
    public List<Agendamento> toAgendamentoList(List<AgendamentoEntity> list);
    public List<AgendamentoResponse> toAgendamentoResponseList(List<Agendamento> list);
}
