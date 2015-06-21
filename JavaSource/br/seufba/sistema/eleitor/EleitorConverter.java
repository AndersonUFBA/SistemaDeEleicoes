package br.seufba.sistema.eleitor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Eleitor.class)
public class EleitorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0){
			Integer codigo =  Integer.valueOf(codigoString);
			EleitorRN eleitorRN = new EleitorRN();
			
		    return eleitorRN.pesquisarPorCodigo(codigo);
			
			
		}
		
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object eleitorObjeto) {
		if(eleitorObjeto != null){
			 Eleitor eleitor = (Eleitor) eleitorObjeto;
			 return eleitor.getId().toString();
		}
		return null;
	}

}
