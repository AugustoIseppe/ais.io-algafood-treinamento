package com.course.ais.io_algafood_api.api.model.dto.output;

import com.course.ais.io_algafood_api.domain.model.Usuario;

public record UserRegisterResponseDTO (
        Long id,
        String name,
        String email,
        String roles
){
    public UserRegisterResponseDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRoles().name()
        );
    }
}
