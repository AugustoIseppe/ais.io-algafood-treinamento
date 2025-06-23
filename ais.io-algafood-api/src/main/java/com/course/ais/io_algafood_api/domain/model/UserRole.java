package com.course.ais.io_algafood_api.domain.model;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER"),
    ANUNCIANTE("ANUNCIANTE"); // Novo tipo de usuário

    private String roles;

    UserRole(String role) {
        this.roles = role;
    }

    public String getRole() {
        return roles;
    }
}
