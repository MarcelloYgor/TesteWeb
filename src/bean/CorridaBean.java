package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.ValidaCorrida;
import rebu.model.Corrida;

@SessionScoped
@ManagedBean(name = "PegaCorrida")
public class CorridaBean {
	private Corrida corrida;
	private List<Corrida> listaCor;
	
	@EJB
	private ValidaCorrida vldCorrida;
	
	public void consultar() {
		listaCor = vldCorrida.consultaCorrida(corrida.getIdCorrida());
	}
	
	public void salvar() {
		
	}
	
	public void cadastrar() {
		
	}
	
	public void excluir() {
		
	}
}
