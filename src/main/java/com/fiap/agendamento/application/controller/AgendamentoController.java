package com.fiap.agendamento.application.controller;

import com.fiap.agendamento.application.controller.dto.AgendamentoResponse;
import com.fiap.agendamento.application.controller.dto.NovoAgendamentoDto;
import com.fiap.agendamento.domain.usecase.ICadastrarAgendamento;
import com.fiap.agendamento.domain.usecase.ICancelarAgendamento;
import com.fiap.agendamento.domain.usecase.IConfirmarAgendamento;
import com.fiap.agendamento.domain.usecase.IListarAgendamentos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/agendamentos")
@RequiredArgsConstructor
@Tag(name = "Agendamentos")
@SecurityRequirement(name = "bearerAuth")
public class AgendamentoController {

    private final ICadastrarAgendamento cadastrarAgendamento;
    private final IListarAgendamentos listarAgendamentos;
    private final IConfirmarAgendamento confirmarAgendamento;
    private final ICancelarAgendamento cancelarAgendamento;

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> listarAgendamento() {
        return ResponseEntity.ok().body(listarAgendamentos.executar());
    }

    @PreAuthorize("hasRole('PACIENTE') or hasRole('MEDICO')")
    @PostMapping
    @Operation(summary = "Cadastrar um novo agendamento", description = "Cadastrar um novo agendamento")
    public ResponseEntity<AgendamentoResponse> cadastrarAgendamento(
            @RequestBody @Valid NovoAgendamentoDto novoAgendamentoDto
    ) {
        return ResponseEntity.status(201).body(cadastrarAgendamento.executar(novoAgendamentoDto));
    }

    @PreAuthorize("hasRole('PACIENTE') or hasRole('MEDICO')")
    @PutMapping("/{id}/confirmar")
    @Operation(summary = "Confirmar agendamento", description = "Confirmar agendamento por ID")
    public ResponseEntity<Void> confirmarAgendamento(
            @PathVariable(name = "id") String idAgendamento
//            @RequestHeader("Authorization") String bearerToken
    ) {
        confirmarAgendamento.executar(UUID.fromString(idAgendamento), "bearerToken");
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('PACIENTE') or hasRole('MEDICO')")
    @PutMapping("/{id}/cancelar")
    @Operation(summary = "Cancelar agendamento", description = "Confirmar agendamento por ID")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable(name = "id") String idAgendamento) {
        cancelarAgendamento.executar(UUID.fromString(idAgendamento));
        return ResponseEntity.ok().build();
    }
}
