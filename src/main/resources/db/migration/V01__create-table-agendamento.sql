CREATE TABLE Agendamento (
    idAgendamento UUID PRIMARY KEY,
    idMedico UUID NOT NULL,
    idPaciente UUID NOT NULL,
    idHorario UUID NOT NULL,
    status VARCHAR(40),
    observacao VARCHAR(255)
);