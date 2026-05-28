package com.javanauta.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javanauta.usuario.business.UsuarioService;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import com.javanauta.usuario.infrastructure.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
		
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UsuarioDTO usuarioDTO) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						usuarioDTO.getEmail(),
						usuarioDTO.getSenha()
						)
				);		
		return "Bearer " + jwtUtil.generateToken(authentication.getName());
	}
	
	@GetMapping
	public ResponseEntity<Usuario> buscaUsuarioPorEmail(@RequestParam("email") String email){
		return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
		
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<Void> deletarUsuarioPorEmail( @PathVariable("email") String email){
		usuarioService.deletarUsuarioPorEmail(email);
		return ResponseEntity.ok().build();
		
		
	}
	
}

