package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import rebu.dao.PassageiroDAO;
import rebu.model.Passageiro;

@Stateless
public class ValidaPassageiro {

	private PassageiroDAO pasDAO = new PassageiroDAO();
	
	public List<Passageiro> consultaPassageiro(String nome) {
		List<Passageiro> retorno = new ArrayList<>();
		retorno = pasDAO.consultarPassageiro(nome);
		return retorno;
	}
	
	public void cadastraPassageiro(Passageiro passageiro) {
		pasDAO.inserirPassageiro(passageiro);
	}
	
	public void alterarPassageiro() {
		
	}
	
	public void excluirPassageiro() {
		
	}
}
