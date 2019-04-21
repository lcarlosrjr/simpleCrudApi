package br.com.luizrezende.cadastro.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.luizrezende.cadastro.domain.base.BaseEntity;

@Entity
public class Usuario extends BaseEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	private Double peso;
	private String estado;
	
	public Usuario() {
		
	}

	public Usuario(String nome, String cpf, Date data_nascimento, Double peso, String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.peso = peso;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
