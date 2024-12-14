package com.github.murilojatoba.unyleya.empresa.entidade;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empresas")
public class Empresa {
	private long id;
	private String nome;
	private String endereco;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Empresa() {
	}
	
	public Empresa(Long id, String nome, String endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}
}
