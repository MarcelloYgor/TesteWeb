package rebu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rebu.datasource.RebuDatasource;
import rebu.model.Motorista;

public class MotoristaDAO {

	private RebuDatasource connection;

	public void inserirMotorista(Motorista motorista) {
		PreparedStatement stmt = null;
		try {
			connection = new RebuDatasource();
			String sql = "INSERT INTO tb_rebu_motorista(nome, dt_nasc, cpf, mod_carro, status, sexo) VALUES (?, ?, ?, ?, ?, ?)";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, motorista.getNome());
			stmt.setDate(2, converteData(motorista.getDtNascimento()));
			stmt.setString(3, motorista.getCpf());
			stmt.setString(4, motorista.getCarroModelo());
			stmt.setBoolean(5, motorista.isStatus());
			stmt.setString(6, motorista.getSexo());
			
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

	public List<Motorista> consultarMotorista(String nome) {
		PreparedStatement stmt = null;
		List<Motorista> retorno = null;
		Motorista motorista = null;
		try {
			connection = new RebuDatasource();
			String sql = "SELECT * FROM tb_rebu_motorista WHERE nome LIKE ?";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, "%" + nome + "%");

			ResultSet result = stmt.executeQuery();
			
			retorno = new ArrayList<>();
			while (result.next()) {
				motorista = new Motorista();
				motorista.setIdMotorista(result.getInt("id_motorista"));
				motorista.setNome(result.getString("nome"));
				motorista.setDtNascimento(result.getDate("dt_nasc"));
				motorista.setCpf(result.getString("cpf"));
				motorista.setCarroModelo(result.getString("mod_carro"));
				motorista.setStatus(result.getBoolean("status"));
				motorista.setSexo(result.getString("sexo"));
				retorno.add(motorista);
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
			String sql = "DELETE FROM tb_rebu_motorista WHERE nome = ?";
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

	public void alterarMotorista() {
		PreparedStatement stmt = null;
		Motorista motorista = null;
		try {
			connection = new RebuDatasource();
			String sql = "UPDATE tb_rebu_motorista SET nome = ?, dt_nasc = ?, cpf = ?, mod_carro = ?, status = ?, sexo = ? WHERE id = ?";
			stmt = connection.getPreparedStatement(sql);
			motorista = new Motorista();
			stmt.setString(1, motorista.getNome());
			stmt.setDate(2, converteData(motorista.getDtNascimento()));
			stmt.setString(3, motorista.getCpf());
			stmt.setString(4, motorista.getCarroModelo());
			stmt.setBoolean(5, motorista.isStatus());
			stmt.setString(6, motorista.getSexo());
			stmt.setInt(7, motorista.getIdMotorista());

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
		System.out.println(dataSql);
		return dataSql;
	}
}
