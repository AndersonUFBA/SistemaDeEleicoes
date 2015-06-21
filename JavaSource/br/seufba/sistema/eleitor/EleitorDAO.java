package br.seufba.sistema.eleitor;

import java.util.List;

public interface EleitorDAO {

	public void salvar(Eleitor eleitor);

	public List<Eleitor> listar();

	public void excluir(Eleitor eleitor);

	public Eleitor pesquisar(String string);

	public void alterar(Eleitor eleitor);

	public Eleitor pesquisarPorCodigo(Integer codigoString);
}
