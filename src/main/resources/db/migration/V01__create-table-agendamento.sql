CREATE TABLE Agendamento (
    idAgendamento UUID PRIMARY KEY,
    pacienteId UUID NOT NULL,
    horarioId UUID NOT NULL,
    status VARCHAR(40),
    observacao VARCHAR(255)
);