package com.kurtphpr.sistema.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.seufba.sistema.chapa.Chapa;
import br.seufba.sistema.chapa.ChapaRN;
import br.seufba.sistema.eleitor.Eleitor;
import br.seufba.sistema.eleitor.EleitorRN;
import br.seufba.sistema.votacao.Votacao;
import br.seufba.sistema.votacao.VotacaoRN;

public class VotacaoTest extends TestHeranca {

	Eleitor c1;
	Eleitor c2;
	Eleitor c3;

	Chapa p1;
	Chapa p2;
	Chapa p3;

	@Before
	public void setup() {
		c1 = new Eleitor("34125365474", "teste1@mail", "Rua 1", "Eleitor 1",
				new Date(), 0);
		c2 = new Eleitor("34125365474", "teste2@mail", "Rua 2", "Eleitor 2",
				new Date(), 0);
		c3 = new Eleitor("34125365474", "teste3@mail", "Rua 3", "Eleitor 3",
				new Date(), 0);

		EleitorRN eleitorRN = new EleitorRN();

		eleitorRN.salvar(c1);
		eleitorRN.salvar(c2);
		eleitorRN.salvar(c3);

		p1 = new Chapa("lote", "Caderno", new Date(), 50);
		p2 = new Chapa("lote2", "Regua", new Date(), 30);
		p3 = new Chapa("fardo", "Papel", new Date(), 300);

		ChapaRN chapaRN = new ChapaRN();

		chapaRN.salvar(p1);
		chapaRN.salvar(p2);
		chapaRN.salvar(p3);

	}

	@After
	public void limpaBanco() {
		VotacaoRN votacaoRN = new VotacaoRN();

		List<Votacao> chapas = votacaoRN.listar();

		for (Votacao chapa : chapas) {
			votacaoRN.excluir(chapa);

		}

	}

	@Test
	public void registraTest() {

		VotacaoRN votacaoRN = new VotacaoRN();

		Votacao votacao1 = new Votacao();
		votacao1.setEleitor(c1);
		votacao1.setChapa(p1);
		votacao1.setDataVotacao(new Date());

		Votacao votacao2 = new Votacao();
		votacao2.setEleitor(c2);
		votacao2.setChapa(p2);
		votacao2.setDataVotacao(new Date());

		Votacao votacao3 = new Votacao();
		votacao3.setEleitor(c3);
		votacao3.setChapa(p3);
		votacao3.setDataVotacao(new Date());

		votacaoRN.registraVotacao(votacao1);
		votacaoRN.registraVotacao(votacao2);
		votacaoRN.registraVotacao(votacao3);

		List<Votacao> votacaos = votacaoRN.listar();

		assertEquals(3, votacaos.size());

	}

}
