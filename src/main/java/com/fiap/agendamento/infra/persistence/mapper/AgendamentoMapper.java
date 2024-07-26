package com.fiap.agendamento.infra.persistence.mapper;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.application.controller.dto.NovoAgendamentoDto;
import com.fiap.agendamento.domain.entity.Agendamento;
import com.fiap.agendamento.infra.persistence.entity.AgendamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AgendamentoMapper {

    public Agendamento toAgendamento(NovoAgendamentoDto novoAgendamentoDto);
    public AgendamentoEntity toAgendamentoEntity(Agendamento agendamento);
    public Agendamento toAgendamento(AgendamentoEntity agendamentoEntity);
    public AgendamentoResponse toAgendamentoResponse(Agendamento agendamento);
    public List<Agendamento> toAgendamentoList(List<AgendamentoEntity> list);
    public List<AgendamentoResponse> toAgendamentoResponseList(List<Agendamento> list);
}
