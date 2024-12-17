package model;

public class Modelo {
	private int id_modelo;
	private String nome_modelo;
	private int id_fabricante;

	public Modelo() {

	}

	public Modelo(int id_modelo) {
		super();
		this.id_modelo = id_modelo;
	}

	public Modelo(int id_modelo, String nome_modelo, int fk_id_fabricante) {
		super();
		this.id_modelo = id_modelo;
		this.nome_modelo = nome_modelo;
		this.id_fabricante = fk_id_fabricante;

	}

	public int getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}

	public String getNome_modelo() {
		return nome_modelo;
	}

	public void setNome_modelo(String nome_modelo) {
		this.nome_modelo = nome_modelo;
	}

	public int getFk_id_fabricante() {
		return id_fabricante;
	}

	public void setFk_id_fabricante(int fk_id_fabricante) {
		this.id_fabricante = fk_id_fabricante;
	}


	@Override
	public String toString() {
		return nome_modelo;
	}

}

