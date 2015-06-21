package br.seufba.sistema.relatorio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.seufba.sistema.eleitor.Eleitor;
import br.seufba.sistema.eleitor.EleitorRN;

@ManagedBean(name = "relatorio")
@ViewScoped
public class RelatorioBean {
	
	
	private Eleitor eleitorSelecionado;
	
	private List<SelectItem> eleitorSelect;

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
	
	public String geraRelatorio(){
		return null;
	}

	public Eleitor getEleitorSelecionado() {
		return eleitorSelecionado;
	}

	public void setEleitorSelecionado(Eleitor eleitorSelecionado) {
		this.eleitorSelecionado = eleitorSelecionado;
	}

}
