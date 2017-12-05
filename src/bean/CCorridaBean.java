package bean;

import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ValidaCorrida;
import ejb.ValidaMotorista;
import ejb.ValidaPassageiro;
import rebu.model.Corrida;
import rebu.model.Motorista;
import rebu.model.Passageiro;

@ViewScoped
@ManagedBean(name="ManterCorrida")
public class CCorridaBean {
	
	private String buscaMot;
	private String buscaPas;
	java.util.Random r = new java.util.Random();
	private double vlCorrida = Double.valueOf(String.format(Locale.US, "%.2f", r.nextDouble() * 100));
	
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
	}
	
	public void pesquisarPassageiro() {
		passageiros = vldPassageiro.consultaPassageiro(buscaPas);
	}
	
	public void solicitarCorrida() {
		if (motorista != null && passageiro != null) {
			System.out.println("Tudo certo");
			corrida = new Corrida();
			corrida.setIdMotCorrida(motorista.getIdMotorista());
			corrida.setIdPasCorrida(passageiro.getIdPassageiro());
			corrida.setVlCorrida(vlCorrida);
			vldCorrida.cadastraCorrida(corrida);
		} else if (motorista == null) {
			System.out.println("Mot porra");
		} else {
			System.out.println("Pas porra");
		}
	}
	
	public void updateBuscaMot() {
		buscaMot = motorista.getNome();
	}
	
	public void updateBuscaPas() {
		buscaPas = passageiro.getNome();
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

	public double getVlCorrida() {
		return vlCorrida;
	}

	public void setVlCorrida(double vlCorrida) {
		this.vlCorrida = vlCorrida;
	}
}
