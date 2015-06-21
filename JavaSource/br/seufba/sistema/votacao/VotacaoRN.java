package br.seufba.sistema.votacao;

import java.util.List;

import br.seufba.sistema.chapa.Chapa;
import br.seufba.sistema.eleitor.Eleitor;
import br.seufba.sistema.util.DAOFactory;

public class VotacaoRN {
	private VotacaoDAO votacaoDAO;

	public VotacaoRN() {
		this.votacaoDAO = DAOFactory.criaVotacaoDAO();
	}
	public void registraVotacao(Votacao votacao) {
		this.votacaoDAO.registra(votacao);

	}

	public List<Votacao> listar() {
		return this.votacaoDAO.getLista();
	}
	public void excluir(Votacao votacao) {
		this.votacaoDAO.excluir(votacao);
		
	}
	public boolean existeNumeroDeVotos(Chapa chapa) {
		return this.votacaoDAO.existeNumeroDeVotosChapa(chapa);
	}
	public void addNumeroDeVotosChapa(Chapa chapa) {
		this.votacaoDAO.addNumeroDeVotosChapa(chapa);		
	}
	
	public void mudarStatusEleitos(Eleitor eleitor) {

	}
	
	public boolean buscarPorId(Integer id){
		return this.votacaoDAO.buscarPorId(id);
	}

}
