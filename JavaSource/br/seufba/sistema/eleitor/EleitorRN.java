package br.seufba.sistema.eleitor;

import java.util.List;

import br.seufba.sistema.util.DAOFactory;

public class EleitorRN {

	private EleitorDAO eleitorDAO;

	public EleitorRN() {
		this.eleitorDAO = DAOFactory.criaEleitorDAO();
	}

	public void salvar(Eleitor c1) {
		this.eleitorDAO.salvar(c1);
	}

	public List<Eleitor> listar() {
		return this.eleitorDAO.listar();
	}

	public void excluir(Eleitor eleitor) {
		this.eleitorDAO.excluir(eleitor);
		
	}

	public Eleitor pesquisar(String string) {
		return this.eleitorDAO.pesquisar(string);
	}

	public void alterar(Eleitor eleitor) {
	 this.eleitorDAO.alterar(eleitor);
		
	}

	public Eleitor pesquisarPorCodigo(Integer codigoString) {
		
		return this.eleitorDAO.pesquisarPorCodigo(codigoString);
	}

}
