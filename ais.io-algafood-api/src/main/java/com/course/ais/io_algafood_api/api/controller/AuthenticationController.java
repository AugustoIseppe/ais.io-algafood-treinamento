package com.course.ais.io_algafood_api.api.controller;

import com.course.ais.io_algafood_api.api.model.dto.input.AuthenticationDTO;
import com.course.ais.io_algafood_api.api.model.dto.input.RegisterDTO;
import com.course.ais.io_algafood_api.api.model.dto.output.LoginResponseDTO;
import com.course.ais.io_algafood_api.api.model.dto.output.UserDTO;
import com.course.ais.io_algafood_api.api.model.dto.output.UserRegisterResponseDTO;
import com.course.ais.io_algafood_api.core.security.TokenService;
import com.course.ais.io_algafood_api.domain.model.Usuario;
import com.course.ais.io_algafood_api.domain.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;



    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());

            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((Usuario) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

     @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        if (usuarioRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.status(400).body(Map.of("error", "User already exists"));
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Usuario usuario = new Usuario();
         usuario.setEmail(data.email());
         usuario.setSenha(encryptedPassword);
         usuario.setNome(data.name());
         usuario.setRoles(data.role());
        usuarioRepository.save(usuario);

        // Retorne o usuário criado como JSON (sem senha)
        return ResponseEntity.status(201).body(new UserRegisterResponseDTO(usuario));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String login = tokenService.validateToken(token);

        if (login.isBlank()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Usuario user = usuarioRepository.findByEmail(login);
        return ResponseEntity.ok(new UserDTO(user));
    }
}
