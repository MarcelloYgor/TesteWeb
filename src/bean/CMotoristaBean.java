package bean;

import java.text.SimpleDateFormat;

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
	
	@EJB
	private ValidaMotorista vldMotorista;
	
	public void salvar() {
		System.out.println(motorista.getNome());
		vldMotorista.cadastraMotorista(motorista);
	}
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
}