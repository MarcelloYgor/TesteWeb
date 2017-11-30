package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ejb.ValidaMotorista;
import rebu.model.Motorista;

@RequestScoped
@ManagedBean(name = "PegaMotorista")
public class MotoristaBean {
	
	private String busca;
	private boolean resultado;
	
	private List<Motorista> listaMot;
	
	@EJB
	private ValidaMotorista vldMotorista;
	
	public void consultar() {
		listaMot = vldMotorista.consultaMotorista(busca);
		for (Motorista mot : listaMot) {
			System.out.println(mot.getCpf());
		}
		resultado = true;
		System.out.println(busca);
	}
	
	public void salvar() {
		
	}
	
	public void cadastrar() {
		
	}
	
	public void excluir() {
		
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<Motorista> getListaMot() {
		return listaMot;
	}

	public void setListaMot(List<Motorista> listaMot) {
		this.listaMot = listaMot;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	
}
