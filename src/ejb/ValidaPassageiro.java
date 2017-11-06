package ejb;

import java.util.ArrayList;
import java.util.List;

import rebu.dao.MotoristaDAO;
import rebu.dao.PassageiroDAO;
import rebu.model.Motorista;
import rebu.model.Passageiro;

public class ValidaPassageiro {

	private PassageiroDAO pasDAO = new PassageiroDAO();
	
	public List<Passageiro> consultaPassageiro(String nome) {
		List<Passageiro> retorno = new ArrayList<>();
		retorno = pasDAO.consultarPassageiro();
		return retorno;
	}
	
	public void cadastraPassageiro() {
		
	}
	
	public void alterarPassageiro() {
		
	}
	
	public void excluirPassageiro() {
		
	}
}
