package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.ValidaCorrida;
import ejb.ValidaMotorista;
import rebu.model.Corrida;
import rebu.model.Motorista;

@ManagedBean(name = "ValidaMotorista")
@SessionScoped
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
