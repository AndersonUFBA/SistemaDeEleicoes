package br.seufba.sistema.util;

import br.seufba.sistema.chapa.ChapaDAO;
import br.seufba.sistema.chapa.ChapaDAOHibernate;
import br.seufba.sistema.eleitor.EleitorDAO;
import br.seufba.sistema.eleitor.EleitorDAOHibernate;
import br.seufba.sistema.votacao.VotacaoDAO;
import br.seufba.sistema.votacao.VotacaoDAOHibernate;

public class DAOFactory {

	public static EleitorDAO criaEleitorDAO() {
		EleitorDAOHibernate eleitorDAOHibernate = new EleitorDAOHibernate();
		eleitorDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return eleitorDAOHibernate;
	}

	public static ChapaDAO criaProdutoDAO() {
		ChapaDAOHibernate produtoDAOHibernate = new ChapaDAOHibernate();
		produtoDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return produtoDAOHibernate;
	}

	public static VotacaoDAO criaVendaDAO() {
		VotacaoDAOHibernate vendaDAOHibernate = new VotacaoDAOHibernate();
		vendaDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return vendaDAOHibernate;
	}
	

	public static ChapaDAO criaChapaDAO() {
		ChapaDAOHibernate chapaDAOHibernate = new ChapaDAOHibernate();
		chapaDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return chapaDAOHibernate;
	}

	public static VotacaoDAO criaVotacaoDAO() {
		VotacaoDAOHibernate votacaoDAOHibernate = new VotacaoDAOHibernate();
		votacaoDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return votacaoDAOHibernate;
	}
}
