package model;

public class Veiculo {
	private int id_carro;
	private String placa;
	private String motor;
	private String ano;
	private int fk_id_cliente;
	private int fk_id_modelo;

	public Veiculo(int id_veiculo) {
		super();
		this.id_carro = id_veiculo;
	}

	public Veiculo(int id_veiculo, String placa, String motor, int id_cliente, int id_modelo, String ano) {
		super();
		this.id_carro = id_veiculo;
		this.placa = placa;
		this.motor = motor;
		this.fk_id_cliente = id_cliente;
		this.fk_id_modelo = id_modelo;
		this.ano = ano;

	}

	public Veiculo() {
		// TODO Auto-generated constructor stub
	}

	public int getId_veiculo() {
		return id_carro;
	}

	public void setId_carro(int id_veiculo) {
		this.id_carro = id_veiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public int getId_cliente() {
		return fk_id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.fk_id_cliente = id_cliente;
	}

	public int getId_modelo() {
		return fk_id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.fk_id_modelo = id_modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Placa: " + placa + ", Motor: " + motor + ", Ano: " + ano;
	}

}