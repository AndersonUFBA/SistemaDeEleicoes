package br.seufba.sistema.chapa;

import java.util.List;

import br.seufba.sistema.chapa.Chapa;

public interface ChapaDAO {

	public void salvar(Chapa chapa);

	public List<Chapa> listar();

	public Chapa pesquisarPorNumero(String numero);

	public void excluir(Chapa chapa);
	
	public void alterar(Chapa chapa);

}
