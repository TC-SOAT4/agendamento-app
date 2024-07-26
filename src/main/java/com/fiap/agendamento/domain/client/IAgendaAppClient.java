package com.fiap.agendamento.domain.client;

import java.util.UUID;

public interface IAgendaAppClient {

    public void confirmarAgendamento(UUID idAgenda, Long idHorario, String bearerToken);

    public void cancelarAgendamento(UUID idAgenda, Long idHorario, String bearerToken);
}
