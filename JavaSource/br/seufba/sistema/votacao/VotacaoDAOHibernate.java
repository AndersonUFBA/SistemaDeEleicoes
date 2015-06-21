package br.seufba.sistema.votacao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import br.seufba.sistema.chapa.Chapa;

public class VotacaoDAOHibernate implements VotacaoDAO {
	private Session sessao;

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void registra(Votacao votacao) {
		this.sessao.saveOrUpdate(votacao);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Votacao> getLista() {
		Criteria lista = sessao.createCriteria(Votacao.class);
		return lista.list();
	}

	@Override
	public void excluir(Votacao votacao) {
		this.sessao.delete(votacao);
	}

	@Override
	public boolean existeNumeroDeVotosChapa(Chapa chapa) {

		Chapa chapaPesquisado = (Chapa) this.sessao.get(Chapa.class,
				chapa.getId());

		if (chapaPesquisado != null) {
		
				return true;
		}

		return false;

	}

	@Override
	public void addNumeroDeVotosChapa(Chapa chapa) {
		String hql = "update Chapa p set p.numeroDeVotos =:novoNumeroDeVotos where p.id =:idChapa";
		Query query = sessao.createQuery(hql);
		query.setInteger("novoNumeroDeVotos", chapa.getNumeroDeVotos() + 1);
		query.setLong("idChapa", chapa.getId());
		query.executeUpdate();

	}
	
	
	@Override
	public boolean buscarPorId(Integer id) {
		 if(findById(id) != null){
			 return false;
		 }		
		return true;
	}
	
	public Votacao findById(Integer id) {  
	   return (Votacao) getSessao().load(Votacao.class, id);  
	    
	} 
	

}
