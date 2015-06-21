package br.seufba.sistema.votacao;

import java.util.List;

import br.seufba.sistema.chapa.Chapa;

public interface VotacaoDAO {

	public void registra(Votacao votacao);

	public List<Votacao> getLista();

	public void excluir(Votacao votacao);

	public boolean existeNumeroDeVotosChapa(Chapa chapa);

	public void addNumeroDeVotosChapa(Chapa chapa);
	
	public boolean buscarPorId(Integer id);

}
