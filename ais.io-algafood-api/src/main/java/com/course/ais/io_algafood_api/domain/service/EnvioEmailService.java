package com.course.ais.io_algafood_api.domain.service;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

import java.util.Map;
import java.util.Set;

public interface EnvioEmailService {

    void enviar(Mensagem mensagem);

    @Builder
    @Getter
    class Mensagem {

        @Singular
        private Set<String> destinatarios;

        private String assunto;

        private String corpo;

        @Singular("variavel")
        private Map<String, Object> variaveis;

    }

}
