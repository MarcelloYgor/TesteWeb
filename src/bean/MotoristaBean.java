package bean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.ValidaMotorista;
import rebu.model.Motorista;

@ManagedBean(name = "ValidaMotorista")
@SessionScoped
public class MotoristaBean {
	
	private Motorista motorista;
	private List<Motorista> listaMot;
	
	@EJB
	private ValidaMotorista vldMotorista;
	
	public void consultar() {
		listaMot = vldMotorista.consultaMotorista(motorista.getNome());
	}
	
	public void salvar() {
		
	}
	
	public void cadastrar() {
		
	}
	
	public void excluir() {
		
	}
}
