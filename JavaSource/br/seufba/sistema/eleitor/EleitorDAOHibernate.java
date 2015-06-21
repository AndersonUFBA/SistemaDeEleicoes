package br.seufba.sistema.eleitor;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class EleitorDAOHibernate implements EleitorDAO {

	private Session sessao;

	@Override
	public void salvar(Eleitor eleitor) {
		this.sessao.save(eleitor);

	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Eleitor> listar() {
		Criteria lista = sessao.createCriteria(Eleitor.class);
		return lista.list();
	}

	@Override
	public void excluir(Eleitor eleitor) {
		this.sessao.delete(eleitor);

	}

	@Override
	public Eleitor pesquisar(String string) {
		Query consultaNome = this.sessao
				.createQuery("from Eleitor c where c.nome like :nome");
		consultaNome.setString("nome", "%" + string + "%");
		return (Eleitor) consultaNome.uniqueResult();
	}

	@Override
	public void alterar(Eleitor eleitor) {
		this.sessao.update(eleitor);
	}

	@Override
	public Eleitor pesquisarPorCodigo(Integer codigo) {
		
		return (Eleitor) this.sessao.get(Eleitor.class, codigo);
	}

}
