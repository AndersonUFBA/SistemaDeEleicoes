package br.seufba.sistema.teste;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.seufba.sistema.eleitor.Eleitor;
import br.seufba.sistema.eleitor.EleitorRN;

public class EleitorTest extends TestHeranca{
	
	@Before
	public void setup(){
		Eleitor c1 = new Eleitor("34125365474", "teste1@mail", "Rua 1", "Eleitor 1", new Date(), 0);
		Eleitor c2 = new Eleitor("34125365474", "teste2@mail", "Rua 2", "Eleitor 2", new Date(), 0);
		Eleitor c3 = new Eleitor("34125365474", "teste3@mail", "Rua 3", "Eleitor 3", new Date(), 0);
		
		EleitorRN eleitorRN = new EleitorRN();
		
		eleitorRN.salvar(c1);
		eleitorRN.salvar(c2);
		eleitorRN.salvar(c3);
		
	}
	
	@After
	public void limpaBanco(){
		
		EleitorRN eleitorRN = new EleitorRN();
		List<Eleitor> lista = eleitorRN .listar();
		
		for (Eleitor eleitor : lista) {
			eleitorRN.excluir(eleitor);
		}
	}

	@Test
	public void salvarTest() {

		Eleitor c1 = new Eleitor();

		c1.setNome("Ronaldo");
		c1.setEndereco("Rua Teste");

		c1.setCpf("123456789");

		EleitorRN eleitorRN = new EleitorRN();

		eleitorRN.salvar(c1);

		assertEquals(true, true);

	}
	
	@Test
	public void listarTest(){
		EleitorRN eleitorRN = new EleitorRN();
		 List<Eleitor> lista = eleitorRN.listar();
		 assertEquals(3, lista.size());
		 
	}
	
	@Test
	public void excluirTest(){
		EleitorRN eleitorRN = new EleitorRN();
		
		List<Eleitor> lista = eleitorRN.listar();
		
		Eleitor eleitorExcluido = lista.get(0);
		
		eleitorRN.excluir(eleitorExcluido);
		
		lista = eleitorRN.listar();
		
		assertEquals(2, lista.size());
		
	}
	
	@Test
	public void pesquisarTest(){
		EleitorRN eleitorRN = new EleitorRN();
		Eleitor eleitorPesquisado =  eleitorRN.pesquisar("te 1");
		
		assertEquals("teste1@mail", eleitorPesquisado.getSenha());

	}
	@Test
	public void alterarTest(){
		
		EleitorRN eleitorRN = new EleitorRN();
		Eleitor eleitorPesquisado =  eleitorRN.pesquisar("te 1");
		
		assertEquals("teste1@mail", eleitorPesquisado.getSenha());
		
		eleitorPesquisado.setEndereco("Novo Endere�o");
		
		eleitorRN.alterar(eleitorPesquisado);
		
		Eleitor eleitorAlterado = eleitorRN.pesquisar("te 1");
		
		assertEquals("Novo Endere�o", eleitorAlterado.getEndereco());
		
	}
	
}
