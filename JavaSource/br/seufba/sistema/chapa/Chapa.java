package br.seufba.sistema.chapa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chapa")
public class Chapa {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	private String numero;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	private Integer numeroDeVotos;


	public Chapa(){
		this.numeroDeVotos = 0;
	}
	
	public Chapa(String nome, String numero, Date dataCadastro,
			Integer numeroDeVotos) {
		
		this.nome = nome;
		this.numero = numero;
		this.dataCadastro = dataCadastro;
		this.numeroDeVotos = numeroDeVotos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getNumeroDeVotos() {
		return numeroDeVotos;
	}

	public void setNumeroDeVotos(Integer numeroDeVotos) {
		this.numeroDeVotos = numeroDeVotos;
	}

	

}
