package ejb;

import java.util.ArrayList;
import java.util.List;

import rebu.dao.CorridaDAO;
import rebu.dao.MotoristaDAO;
import rebu.model.Corrida;
import rebu.model.Motorista;

public class ValidaCorrida {

	private CorridaDAO corDAO = new CorridaDAO();
	
	public List<Corrida> consultaCorrida(int id) {
		List<Corrida> retorno = new ArrayList<>();
		retorno = corDAO.consultarCorrida();
		return retorno;
	}
	
	public void cadastraCorrida() {
		
	}
	
	public void alterarCorrida() {
		
	}
	
	public void excluirCorrida() {
		
	}
}
