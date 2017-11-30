package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.ValidaPassageiro;
import rebu.model.Passageiro;

@SessionScoped
@ManagedBean(name = "PegaPassageiro")
public class PassageiroBean {
	
	private Passageiro passageiro;
	private List<Passageiro> listaPas;
	
	@EJB
	private ValidaPassageiro vldPassageiro;
	
	public void consultar() {
		System.out.println("porra");
	}
	
	public void salvar() {
		
	}
	
	public void cadastrar() {
		
	}
	
	public void excluir() {
		
	}
}
