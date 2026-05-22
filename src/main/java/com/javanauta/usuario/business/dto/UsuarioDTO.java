package com.javanauta.usuario.business.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String nome;
	private String email;
	private String senha;
	private List<EnderecoDTO> enderecos;
	private List<TelefoneDTO> telefones;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}
	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}
	
	
}
