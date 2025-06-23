package com.course.ais.io_algafood_api.api.model.dto.output;


import com.course.ais.io_algafood_api.domain.model.Usuario;

public record UserDTO(
        Long id,
        String name,
        String email,
        String role
) {
    public UserDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRoles().name()
        );
    }
}
