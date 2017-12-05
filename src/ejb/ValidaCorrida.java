package ejb;

import java.util.List;

import javax.ejb.Stateless;

import rebu.dao.CorridaDAO;
import rebu.model.Corrida;

@Stateless
public class ValidaCorrida {

	private CorridaDAO corDAO = new CorridaDAO();
	
	public List<Corrida> consultaCorrida() {
		List<Corrida> retorno;
		retorno = corDAO.consultarCorrida();
		return retorno;
	}
	
	public void cadastraCorrida(Corrida corrida) {
		corDAO.inserirCorrida(corrida);
	}
	
	public void alterarCorrida() {
		
	}
	
	public void excluirCorrida() {
		
	}
}
