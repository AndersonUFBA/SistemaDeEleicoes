package br.seufba.sistema.votacao;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.seufba.sistema.chapa.Chapa;
import br.seufba.sistema.eleitor.Eleitor;

@Entity
@Table(name = "votacao")
public class Votacao {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_eleitor", nullable=false)
	private Eleitor eleitor;

	@ManyToOne
	@JoinColumn(name = "id_chapa", nullable=false)
	private Chapa chapa;

	@Column(name = "data_votacao")
	private Date dataVotacao;

	public Votacao(Chapa chapa, Eleitor eleitorSelecionado) {
		this.chapa = chapa;
		this.eleitor = eleitorSelecionado;
	}

	public Votacao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Chapa getChapa() {
		return chapa;
	}

	public void setChapa(Chapa chapa) {
		this.chapa = chapa;
	}

	public Date getDataVotacao() {
		return dataVotacao;
	}

	public void setDataVotacao(Date dataVotacao) {
		this.dataVotacao = dataVotacao;
	}

}
