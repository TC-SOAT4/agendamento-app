package com.fiap.agendamento.infra.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SqsAgendamentoListenerTest {

    @Autowired
    private SqsAgendamentoListener sqsAgendamentoListener;

//    @Test
    void receiveMessage() throws JsonProcessingException {
        String mensagem = "{\n" +
                "  \"idMedico\": \"49f3c019-0660-420b-82cf-57bf30627138\",\n" +
                "  \"idPaciente\": \"49f3c019-0660-420b-82cf-57bf30627138\",\n" +
                "  \"idHorario\": \"2ea15901-f4f3-42d9-83bf-2cb91f18f6b7\"\n" +
                "}";

        sqsAgendamentoListener.receiveMessage(mensagem);
    }
}