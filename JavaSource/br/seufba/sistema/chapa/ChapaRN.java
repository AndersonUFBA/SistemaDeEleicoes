package br.seufba.sistema.chapa;

import java.util.List;

import br.seufba.sistema.chapa.Chapa;
import br.seufba.sistema.util.DAOFactory;

public class ChapaRN {
	
	private ChapaDAO chapaDAO;

	public ChapaRN() {
		this.chapaDAO = DAOFactory.criaChapaDAO();
	}

	public void salvar(Chapa chapa) {
	this.chapaDAO.salvar(chapa);
		
	}

	public List<Chapa> listar() {
	 return this.chapaDAO.listar();
	}

	public Chapa pesquisarPorNome(String numero) {
		return this.chapaDAO.pesquisarPorNumero(numero);
	}

	public void excluir(Chapa chapa) {
	this.chapaDAO.excluir(chapa);
		
	}
	

	public void alterar(Chapa chapa) {
	 this.chapaDAO.alterar(chapa);
	}
}
