CREATE TABLE Agendamento (
    idAgendamento UUID PRIMARY KEY,
    idAgenda UUID NOT NULL,
    idMedico UUID NOT NULL,
    idPaciente UUID NOT NULL,
    idHorario INT NOT NULL,
    status VARCHAR(40),
    observacao VARCHAR(255)
);