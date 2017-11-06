package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.ValidaMotorista;
import ejb.ValidaPassageiro;
import rebu.model.Motorista;
import rebu.model.Passageiro;

@ManagedBean(name = "ValidaMotorista")
@SessionScoped
public class PassageiroBean {
	
	private Passageiro passageiro;
	private List<Passageiro> listaPas;
	
	@EJB
	private ValidaPassageiro vldPassageiro;
	
	public void consultar() {
		listaPas = vldPassageiro.consultaPassageiro(passageiro.getNome());
	}
	
	public void salvar() {
		
	}
	
	public void cadastrar() {
		
	}
	
	public void excluir() {
		
	}
}
