package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ejb.ValidaMotorista;
import rebu.model.Motorista;

@RequestScoped
@ManagedBean(name="ManterMotorista")
public class CMotoristaBean {

	private Motorista motorista;
	private int idMotorista;
	private String nome;
	private Date dtNascimento;
	private String cpf;
	private String carroModelo;
	private boolean status;
	private String sexo;
	
	@EJB
	private ValidaMotorista vldMotorista;
	
	public void salvar() {
		System.out.println(nome);
		System.out.println(dtNascimento);
		System.out.println(cpf);
		System.out.println(carroModelo);
		System.out.println(status);
		System.out.println(sexo);
		motorista = new Motorista();
		motorista.setNome(nome);
		motorista.setDtNascimento(dtNascimento);
		motorista.setCpf(cpf);
		motorista.setCarroModelo(carroModelo);
		motorista.setStatus(status);
		motorista.setSexo(sexo);
		vldMotorista.cadastraMotorista(motorista);
	}
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

	public int getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCarroModelo() {
		return carroModelo;
	}

	public void setCarroModelo(String carroModelo) {
		this.carroModelo = carroModelo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}