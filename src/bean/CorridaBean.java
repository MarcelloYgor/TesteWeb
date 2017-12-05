package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.ValidaCorrida;
import rebu.model.Corrida;

@SessionScoped
@ManagedBean(name = "PegaCorrida")
public class CorridaBean {
	
	private List<Corrida> listaCor;
	private boolean resultado;
	
	@EJB
	private ValidaCorrida vldCorrida;
	
	@PostConstruct
	public void init() {
		setListaCor(vldCorrida.consultaCorrida());
		setResultado(true);
	}
	
	public void salvar() {
		
	}
	
	public void excluir() {
		
	}

	public List<Corrida> getListaCor() {
		return listaCor;
	}

	public void setListaCor(List<Corrida> listaCor) {
		this.listaCor = listaCor;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
}
