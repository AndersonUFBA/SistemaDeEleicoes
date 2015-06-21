package br.seufba.sistema.votacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.seufba.sistema.chapa.Chapa;
import br.seufba.sistema.chapa.ChapaRN;
import br.seufba.sistema.eleitor.Eleitor;
import br.seufba.sistema.eleitor.EleitorRN;

@ManagedBean(name = "registroVotacaos")
@ViewScoped
public class RegistroVotacaoBean {

	private Eleitor eleitorSelecionado;
	private Chapa chapaSelecionado = new Chapa();
	private List<Chapa> urna = new ArrayList<Chapa>();
	private List<SelectItem> eleitorSelect;
	

	public String buscarChapa() {

		ChapaRN chapaRN = new ChapaRN();
		Chapa chapaPesquisado = new Chapa();

		if (this.chapaSelecionado.getNumero() != null
				&& !this.chapaSelecionado.getNumero().equals("")) {
			chapaPesquisado = chapaRN
					.pesquisarPorNome(this.chapaSelecionado.getNumero());

			if (chapaPesquisado != null) {

				this.urna.add(chapaPesquisado);
				

			}

		}

		return null;
	}

	
	
	public String finalizarVotacao(){
		
		
		if(!this.urna.isEmpty()){
			ArrayList<Votacao> votacaos = new ArrayList<Votacao>();
			VotacaoRN votacaoRN =  new VotacaoRN();
			
			for (Chapa chapa : this.urna) {
				
				if(this.eleitorSelecionado != null){
					if(votacaoRN.existeNumeroDeVotos(chapa)){
						votacaos.add(new Votacao(chapa, this.eleitorSelecionado));
					}
				}
			}
			
			
			for (Votacao votacao : votacaos) {
				if(votacao.getEleitor().getVotou() == 0){
					votacao.setDataVotacao(new Date());
					votacaoRN.registraVotacao(votacao);
					votacaoRN.addNumeroDeVotosChapa(votacao.getChapa());
					votacao.getEleitor().setVotou(1);
				}else{
					return "naopodevotar";
				}
			}
		
			
		}
		
	  return "votacaosucesso";
	}
	
	
	

	public String excluirChapaUrna(){
		
		if(this.urna != null && !this.urna.isEmpty()){
			if(this.chapaSelecionado != null){
				this.urna.remove(this.chapaSelecionado);
			}
		}
		
		return null;
	}
	public Eleitor getEleitorSelecionado() {
		return eleitorSelecionado;
	}

	public void setEleitorSelecionado(Eleitor eleitorSelecionado) {
		this.eleitorSelecionado = eleitorSelecionado;
	}

	public Chapa getChapaSelecionado() {
		return chapaSelecionado;
	}

	public void setChapaSelecionado(Chapa chapaSelecionado) {
		this.chapaSelecionado = chapaSelecionado;
	}

	public List<Chapa> getUrna() {
		return urna;
	}

	public void setUrna(List<Chapa> urna) {
		this.urna = urna;
	}

	public List<SelectItem> getEleitorSelect() {

		if (eleitorSelect == null) {

			eleitorSelect = new ArrayList<SelectItem>();
			EleitorRN eleitorRN = new EleitorRN();
			List<Eleitor> listaEleitors = eleitorRN.listar();

			if (listaEleitors != null && !listaEleitors.isEmpty()) {
				SelectItem item;
				for (Eleitor eleitorLista : listaEleitors) {
					item = new SelectItem(eleitorLista, eleitorLista.getNome());
					eleitorSelect.add(item);
				}
			}

		}

		return eleitorSelect;
	}

	public void setEleitorSelect(List<SelectItem> eleitorSelect) {
		this.eleitorSelect = eleitorSelect;
	}

}
