package br.seufba.sistema.chapa;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.seufba.sistema.chapa.Chapa;
import br.seufba.sistema.chapa.ChapaRN;

@ManagedBean(name = "chapaBean")
@RequestScoped
public class ChapaBean {
	private Chapa chapaSelecionado = new Chapa();

	private List<Chapa> lista = null;

	public void salvar() {
		ChapaRN chapaRN = new ChapaRN();
		chapaSelecionado.setDataCadastro(new Date());
		if (this.chapaSelecionado.getId() != null	&& this.chapaSelecionado.getId() != 0) {
			chapaRN.alterar(this.chapaSelecionado);
		} else {
			chapaRN.salvar(chapaSelecionado);
			FacesMessage faces = new FacesMessage(
					"Chapa cadastrado com sucesso!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
		this.lista = null;

	}

	public Chapa getChapaSelecionado() {
		return chapaSelecionado;
	}

	public void setChapaSelecionado(Chapa chapaSelecionado) {
		this.chapaSelecionado = chapaSelecionado;
	}

	public List<Chapa> getLista() {
		ChapaRN chapaRN = new ChapaRN();
		if (lista == null) {
			lista = chapaRN.listar();
		}
		return lista;
	}

	public void excluir() {
		ChapaRN chapaRN = new ChapaRN();
		chapaRN.excluir(this.chapaSelecionado);
		this.lista = null;
	}

	public void novo() {
		this.chapaSelecionado = new Chapa();
	}
}
