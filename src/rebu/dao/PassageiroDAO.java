package rebu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rebu.datasource.RebuDatasource;
import rebu.model.Passageiro;

public class PassageiroDAO {
	
	private RebuDatasource connection;
	
	public void inserirPassageiro() {
		PreparedStatement stmt = null;
		Passageiro passageiro = null;
		try {
			connection = new RebuDatasource();
			String sql = "INSERT INTO tb_passageiro(nome, dt_nasc, cpf, sexo) VALUES (?, ?, ?, ?);";
			stmt = connection.getPreparedStatement(sql);
			passageiro = new Passageiro();
			stmt.setString(1, passageiro.getNome());
			stmt.setDate(2, converteData(passageiro.getDtNascimento()));
			stmt.setString(3, passageiro.getCpf());
			stmt.setString(4, passageiro.getSexo());
		} catch (SQLException e) {
			System.out.println("Couldnt save object in database!\n SqlState: " + e.getSQLState() + "\nErrorCode: "
					+ e.getErrorCode() + " " + "\nMessage: " + e.getMessage());
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}
	
	public List<Passageiro> consultarPassageiro(String nome) {
		PreparedStatement stmt = null;
		List<Passageiro> retorno = null;
		Passageiro passageiro = null;
		try {
			connection = new RebuDatasource();
			String sql = "SELECT * FROM tb_passageiro WHERE nome = ?";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();
			
			retorno = new ArrayList<>();
			while (result.next()) {
				result.next();
				passageiro = new Passageiro();
				passageiro.setIdPassageiro(result.getInt("id_passageiro"));
				passageiro.setNome(result.getString("nome"));
				passageiro.setDtNascimento(result.getDate("dt_nasc"));
				passageiro.setCpf(result.getString("cpf"));
				passageiro.setSexo(result.getString("sexo"));
				retorno.add(passageiro);
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

	public void excluirMotorista(String nome) {
		PreparedStatement stmt = null;
		try {
			connection = new RebuDatasource();
			String sql = "DELETE FROM tb_passageiro WHERE nome = ?;";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, nome);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}

	public void alterarPassageiro() {
		PreparedStatement stmt = null;
		Passageiro passageiro = null;
		try {
			connection = new RebuDatasource();
			String sql = "UPDATE tb_passageiro SET nome = ?, dt_nasc = ?, cpf = ?, sexo = ? WHERE id = ?;";
			stmt = connection.getPreparedStatement(sql);
			passageiro = new Passageiro();
			stmt.setString(1, passageiro.getNome());
			stmt.setDate(2, converteData(passageiro.getDtNascimento()));
			stmt.setString(3, passageiro.getCpf());
			stmt.setString(4, passageiro.getSexo());
			stmt.setInt(4, passageiro.getIdPassageiro());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}
	
	private java.sql.Date converteData(java.util.Date dataUtil) {
		java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
		return dataSql;
	}
}
