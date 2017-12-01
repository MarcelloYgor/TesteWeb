package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.ValidaCorrida;
import ejb.ValidaMotorista;
import ejb.ValidaPassageiro;
import rebu.model.Corrida;
import rebu.model.Motorista;
import rebu.model.Passageiro;

@SessionScoped
@ManagedBean(name="ManterCorrida")
public class CCorridaBean {
	
	private String buscaMot;
	private String buscaPas;
	
	private List<Motorista> motoristas;
	private List<Passageiro> passageiros;
	
	private Motorista motorista;
	private Passageiro passageiro;
	private Corrida corrida;
	
	@EJB
	private ValidaCorrida vldCorrida;
	
	@EJB
	private ValidaMotorista vldMotorista;
	
	@EJB
	private ValidaPassageiro vldPassageiro;
	
	public void pesquisarMotorista() {
		motoristas = vldMotorista.consultaMotorista(buscaMot);
		for (Motorista mot : motoristas) {
			System.out.println(mot.getNome());
		}
	}
	
	public void pesquisarPassageiro() {
		setPassageiros(vldPassageiro.consultaPassageiro(buscaPas));
	}
	
	public void solicitarCorrida() {
		
	}
	
	public void updateBusca() {
		System.out.println(motorista.getNome());
	}

	public String getBuscaMot() {
		return buscaMot;
	}

	public void setBuscaMot(String buscaMot) {
		this.buscaMot = buscaMot;
	}

	public String getBuscaPas() {
		return buscaPas;
	}

	public void setBuscaPas(String buscaPas) {
		this.buscaPas = buscaPas;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public List<Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
}
