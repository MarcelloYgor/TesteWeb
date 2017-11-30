package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ejb.ValidaPassageiro;
import rebu.model.Passageiro;

@RequestScoped
@ManagedBean(name = "PegaPassageiro")
public class PassageiroBean {
	
	private String busca;
	private boolean resultado;
	
	private List<Passageiro> listaPas;
	
	@EJB
	private ValidaPassageiro vldPassageiro;
	
	public void consultar() {
		listaPas = vldPassageiro.consultaPassageiro(busca);
		resultado = true;
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

	public List<Passageiro> getListaPas() {
		return listaPas;
	}

	public void setListaPas(List<Passageiro> listaPas) {
		this.listaPas = listaPas;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
}
