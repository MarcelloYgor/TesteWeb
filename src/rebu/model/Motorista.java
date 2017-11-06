package rebu.model;

import java.util.Date;

public class Motorista {

	private int idMotorista;
	private String nome;
	private Date dtNascimento;
	private String cpf;
	private String carroModelo;
	private boolean status;
	private String sexo;

	public int getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCarroModelo() {
		return carroModelo;
	}

	public void setCarroModelo(String carroModelo) {
		this.carroModelo = carroModelo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
