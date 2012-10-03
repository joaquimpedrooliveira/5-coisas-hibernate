package br.ufc.quixada.escolaferias.banco.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conta {

	@Id
	private int numero;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="CLIENTE_ID")
	private Cliente dono;

	public Conta() {}
	
	public Conta(int numero, String descricao) {
		super();
		this.numero = numero;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
}
