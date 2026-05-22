package com.javanauta.usuario.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javanauta.usuario.business.converter.UsuarioConverter;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import com.javanauta.usuario.infrastructure.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioConverter usuarioConverter;
	
	public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
		
		Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
		
		usuario  = usuarioRepository.save(usuario);
	}
	
}
