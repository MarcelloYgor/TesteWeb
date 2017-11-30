package ejb;

import java.util.ArrayList;
import java.util.List;

import rebu.dao.CorridaDAO;
import rebu.model.Corrida;

public class ValidaCorrida {

	private CorridaDAO corDAO = new CorridaDAO();
	
	public List<Corrida> consultaCorrida(int id) {
		List<Corrida> retorno = new ArrayList<>();
		retorno = corDAO.consultarCorrida(id);
		return retorno;
	}
	
	public void cadastraCorrida() {
		
	}
	
	public void alterarCorrida() {
		
	}
	
	public void excluirCorrida() {
		
	}
}
