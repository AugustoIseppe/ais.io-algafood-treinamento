package com.course.ais.io_algafood_api.api.model.dto.input;

import com.course.ais.io_algafood_api.domain.model.UserRole;

public record RegisterDTO(String password, String name, String email, UserRole role) {
}
