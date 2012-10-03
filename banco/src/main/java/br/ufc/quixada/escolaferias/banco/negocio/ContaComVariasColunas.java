package br.ufc.quixada.escolaferias.banco.negocio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="CONTA_VARIAS_COLUNAS")
//@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
//@DynamicInsert  //Novo na versão 4. Bugado até a 4.1.3 
//@DynamicUpdate
public class ContaComVariasColunas {

	@Id
	private int numero;
	
	private String descricao;
		
	private Date dataAbertura;
	
	private double saldo;
	
	private String pacoteServicos;

	public ContaComVariasColunas() {}
	

	public ContaComVariasColunas(int numero, String descricao,
			Date dataAbertura, double saldo, String pacoteServicos) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
		this.pacoteServicos = pacoteServicos;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}	

	
}
