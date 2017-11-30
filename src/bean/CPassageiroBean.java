package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ejb.ValidaPassageiro;
import rebu.model.Passageiro;

@RequestScoped
@ManagedBean(name="ManterPassageiro")
public class CPassageiroBean {

	private Passageiro passageiro;
	private int idPassageiro;
	private String nome;
	private Date dtNascimento;
	private String cpf;
	private String sexo;
	
	@EJB
	private ValidaPassageiro vldPassageiro;
	
	public void salvar() {
		System.out.println(nome);
		System.out.println(dtNascimento);
		System.out.println(cpf);
		System.out.println(sexo);
		passageiro = new Passageiro();
		passageiro.setNome(nome);
		passageiro.setDtNascimento(dtNascimento);
		passageiro.setCpf(cpf);
		passageiro.setSexo(sexo);
		vldPassageiro.cadastraPassageiro(passageiro);
	}
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

	public int getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(int idPassageiro) {
		this.idPassageiro = idPassageiro;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}