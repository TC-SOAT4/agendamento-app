CREATE TABLE Agendamento (
    idAgendamento UUID PRIMARY KEY,
    idMedico UUID NOT NULL,
    idPaciente UUID NOT NULL,
    idHorario INT NOT NULL,
    status VARCHAR(40),
    observacao VARCHAR(255),
    dia DATE NOT NULL,
    inicio TIME NOT NULL,
    fim TIME NOT NULL
);

