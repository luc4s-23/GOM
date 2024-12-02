package model;

public class Veiculo {
	private int id_veiculo;
	private String placa;
	private String motor;
	private int id_cliente;
	private int id_modelo;
	public Veiculo(int id_veiculo, String placa, String motor, int id_cliente, int id_modelo) {
		super();
		this.id_veiculo = id_veiculo;
		this.placa = placa;
		this.motor = motor;
		this.id_cliente = id_cliente;
		this.id_modelo = id_modelo;
		
	}
	public int getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
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
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_modelo() {
		return id_modelo;
	}
	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}
	
	
}
