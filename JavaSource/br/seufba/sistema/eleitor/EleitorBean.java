package br.seufba.sistema.eleitor;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "eleitorBean")
@RequestScoped
public class EleitorBean {

	private Eleitor eleitorSelecionado = new Eleitor();

	private List<Eleitor> lista = null;

	public void salvar() {
		EleitorRN eleitorRN = new EleitorRN();
		eleitorSelecionado.setDataCadastro(new Date());
		if (this.eleitorSelecionado.getId() != null	&& this.eleitorSelecionado.getId() != 0) {
			eleitorRN.alterar(this.eleitorSelecionado);
		} else {
			eleitorRN.salvar(eleitorSelecionado);
			FacesMessage faces = new FacesMessage(
					"Eleitor cadastrado com sucesso!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
		this.lista = null;

	}

	public Eleitor getEleitorSelecionado() {
		return eleitorSelecionado;
	}

	public void setEleitorSelecionado(Eleitor eleitorSelecionado) {
		this.eleitorSelecionado = eleitorSelecionado;
	}

	public List<Eleitor> getLista() {
		EleitorRN eleitorRN = new EleitorRN();
		if (lista == null) {
			lista = eleitorRN.listar();
		}
		return lista;
	}

	public void excluir() {
		EleitorRN eleitorRN = new EleitorRN();
		eleitorRN.excluir(this.eleitorSelecionado);
		this.lista = null;
	}

	public void novo() {
		this.eleitorSelecionado = new Eleitor();
	}
}
