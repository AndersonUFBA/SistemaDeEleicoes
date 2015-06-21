package br.seufba.sistema.chapa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import br.seufba.sistema.chapa.Chapa;

public class ChapaDAOHibernate implements ChapaDAO {

	private Session sessao;

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(Chapa chapa) {
		this.sessao.save(chapa);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chapa> listar() {
		Criteria lista = sessao.createCriteria(Chapa.class);

		return lista.list();
	}

	@Override
	public Chapa pesquisarPorNumero(String numero) {
		String sql = "from Chapa p where p.numero like :numero";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("numero", "%" + numero + "%");
		return (Chapa) consulta.uniqueResult();
	}

	@Override
	public void excluir(Chapa chapa) {
		this.sessao.delete(chapa);

	}
	
	@Override
	public void alterar(Chapa chapa) {
		this.sessao.update(chapa);
	}

}
