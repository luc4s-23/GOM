package model;

public class Fabricante {
	private static int id_fabricante;
	private String nome_fabricante;
	
	public Fabricante(int id_fabricante, String nome_fabricante) {
		super();
		this.id_fabricante = id_fabricante;
		this.nome_fabricante = nome_fabricante;
	}
	
	public Fabricante() {
		// TODO Auto-generated constructor stub
	}

	public int getId_fabricante() {
		return id_fabricante;
	}
	public void setId_fabricante(int id_fabricante) {
		this.id_fabricante = id_fabricante;
	}
	public String getNome_fabricante() {
		return nome_fabricante;
	}
	public void setNome_fabricante(String nome_fabricante) {
		this.nome_fabricante = nome_fabricante;
	}

	public static String toDetalhesString() {
		return "Fabricante: " + id_fabricante;
	}
	
	@Override
	public String toString() {
		return nome_fabricante;
	}
	
	
	
}
