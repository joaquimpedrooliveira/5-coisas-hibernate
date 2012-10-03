package br.ufc.quixada.escolaferias.banco.negocio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CLIENTE_ID")
	private Set<Conta> contas = new HashSet<Conta>();

	public Cliente() {} 
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Set<Conta> getContas() {
		return contas;
	}

	public void adicionaConta(Conta conta) {
		conta.setDono(this);
		contas.add(conta);
	}
	
	public void removeConta(Conta conta) {
		conta.setDono(null);
		contas.remove(conta);
	}

}