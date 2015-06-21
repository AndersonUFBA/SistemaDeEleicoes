package br.seufba.sistema.teste;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.seufba.sistema.chapa.Chapa;
import br.seufba.sistema.chapa.ChapaRN;

public class ChapaTest extends TestHeranca {

	@Before
	public void setup() {
		Chapa p1 = new Chapa("lote", "Caderno", new Date(), 50);
		Chapa p2 = new Chapa("lote2", "Regua", new Date(), 30);
		Chapa p3 = new Chapa("fardo", "Papel", new Date(), 300);
		Chapa p4 = new Chapa("edicao", "Livro", new Date(), 10);
		Chapa p5 = new Chapa("caixa", "Caneta", new Date(), 90);

		ChapaRN chapaRN = new ChapaRN();
		chapaRN.salvar(p1);
		chapaRN.salvar(p2);
		chapaRN.salvar(p3);
		chapaRN.salvar(p4);
		chapaRN.salvar(p5);

	}

	@After
	public void limpaBanco() {
		// Criteria lista = sessao.createCriteria(Chapa.class);
		// @SuppressWarnings("unchecked")

		ChapaRN chapaRN = new ChapaRN();

		List<Chapa> chapas = chapaRN.listar();

		for (Chapa chapa : chapas) {
			chapaRN.excluir(chapa);

		}

	}

	@Test
	public void salvarChapaTest() {

		// Query consulta = pesquisar("Re");
		// Chapa chapaPesquisado = (Chapa) consulta.uniqueResult();
		//
		ChapaRN chapaRN = new ChapaRN();

		Chapa chapaSalvo = new Chapa("lote33", "Apontador", new Date(),
				110);

		chapaRN.salvar(chapaSalvo);

		Chapa chapaPesquisado = chapaRN.pesquisarPorNome("Apo");

		assertEquals("lote33", chapaPesquisado.getNome());

	}

	@Test
	public void listaChapasTest() {

		// Criteria lista = sessao.createCriteria(Chapa.class);
		// @SuppressWarnings("unchecked")
		// List<Chapa> chapas = lista.list();
		//
		ChapaRN chapaRN = new ChapaRN();
		List<Chapa> chapas = chapaRN.listar();

		assertEquals(5, chapas.size());

	}

	// @Test
	// public void excluirChapaTest(){
	// Query consulta = pesquisar("Papel");
	// Chapa chapaDeletado = (Chapa) consulta.uniqueResult();
	// sessao.delete(chapaDeletado);
	//
	// chapaDeletado = (Chapa) consulta.uniqueResult();
	//
	// assertNull(chapaDeletado);
	//
	//
	// }

	// @Test
	// public void alteracaoChapaTest(){
	// Query consulta = pesquisar("Livro");
	// Chapa chapaAlterado = (Chapa) consulta.uniqueResult();
	// chapaAlterado.setEstoque(100);
	//
	// sessao.update(chapaAlterado);
	//
	// chapaAlterado = (Chapa) consulta.uniqueResult();
	//
	// assertEquals(100, chapaAlterado.getEstoque().intValue());
	//
	// }

	// private Query pesquisar(String parametro) {
	// String sql = "from Chapa p where p.descricao like :descricao";
	// Query consulta = sessao.createQuery(sql);
	// consulta.setString("descricao", "%"+parametro+"%");
	// return consulta;
	// }

}
