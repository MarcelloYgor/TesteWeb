package rebu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rebu.datasource.RebuDatasource;
import rebu.model.Corrida;

public class CorridaDAO {

	private RebuDatasource connection;

	public void inserirCorrida(Corrida corrida) {
		PreparedStatement stmt = null;
		try {
			connection = new RebuDatasource();
			String sql = "INSERT INTO tb_rebu_corrida(id_mot_corrida, id_pas_corrida, vl_corrida) VALUES (?, ?, ?)";
			stmt = connection.getPreparedStatement(sql);
			stmt.setInt(1, corrida.getIdMotCorrida());
			stmt.setInt(2, corrida.getIdPasCorrida());
			stmt.setDouble(3, corrida.getVlCorrida());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Couldnt save object in database!\n SqlState: " + e.getSQLState() + "\nErrorCode: "
					+ e.getErrorCode() + " " + "\nMessage: " + e.getMessage());
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}

	public List<Corrida> consultarCorrida() {
		PreparedStatement stmt = null;
		List<Corrida> retorno = null;
		Corrida corrida = null;
		try {
			connection = new RebuDatasource();
			String sql = "SELECT * FROM tb_rebu_corrida";
			stmt = connection.getPreparedStatement(sql);

			ResultSet result = stmt.executeQuery();
			
			retorno = new ArrayList<>();
			while (result.next()) {
				corrida = new Corrida();
				corrida.setIdCorrida(result.getInt("id_corrida"));;
				corrida.setIdMotCorrida(result.getInt("id_mot_corrida"));
				corrida.setIdPasCorrida(result.getInt("id_pas_corrida"));
				corrida.setVlCorrida(result.getDouble("vl_corrida"));
				retorno.add(corrida);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				connection.closeConnection(stmt);
			}
		}
		return retorno;
	}

	public void excluirCorrida(int id) {
		PreparedStatement stmt = null;
		try {
			connection = new RebuDatasource();
			String sql = "DELETE FROM tb_rebu_corrida WHERE id = ?";
			stmt = connection.getPreparedStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}

	public void alterarCorrida() {
		PreparedStatement stmt = null;
		Corrida corrida = null;
		try {
			connection = new RebuDatasource();
			String sql = "UPDATE tb_rebu_corrida SET id_mot_corrida = ?, id_pas_corrida = ?, vl_corrida = ? WHERE id = ?";
			stmt = connection.getPreparedStatement(sql);
			corrida = new Corrida();
			stmt.setInt(1, corrida.getIdMotCorrida());
			stmt.setInt(2, corrida.getIdPasCorrida());
			stmt.setDouble(3, corrida.getVlCorrida());
			stmt.setInt(4, corrida.getIdCorrida());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}
}
