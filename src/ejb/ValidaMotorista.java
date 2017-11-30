package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import rebu.dao.MotoristaDAO;
import rebu.model.Motorista;

@Stateless
public class ValidaMotorista {
	
	private MotoristaDAO motDAO = new MotoristaDAO();
	
	public List<Motorista> consultaMotorista(String nome) {
		List<Motorista> retorno = new ArrayList<>();
		retorno = motDAO.consultarMotorista(nome);
		for (Motorista mot : retorno) {
			System.out.println(mot.getCpf());
		}
		return retorno;
	}
	
	public void cadastraMotorista(Motorista motorista) {
		motDAO.inserirMotorista(motorista);
	}
	
	public void alterarMotorista() {
		
	}
	
	public void excluirMotorista() {
		
	}
}
