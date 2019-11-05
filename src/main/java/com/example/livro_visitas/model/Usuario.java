package com.example.livro_visitas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date data;
	
	@NotBlank(message="Digite um nome válido !")
	@Size(max=25, message="Informe um nome contendo até 25 caracteres")
	private String nome;
	
	@NotBlank(message="Digite uma mensagem válida !")
	@Size(max=40, message="Digite uma mensagem contendo até 40 caracteres")
	private String mensagem;
	
	public Usuario(String nome, Long id, Date data, String mensagem) {
		this.nome = nome;
		this.id = id;
		this.data = data;
		this.mensagem = mensagem;
	}

	public Usuario() {
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	@PrePersist
	private void dataCriacao() {
		data = new Date();
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
