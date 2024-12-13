package model;

public class Cliente {
	private int id_cliente;
	private String nome_cliente;
	private String endereco_cliente;
	private String cpf_cliente;
	private String email_cliente;
	private String telefone_cliente;

	public Cliente(int id_cliente, String nome_cliente, String endereco_cliente, String cpf_cliente,
			String email_cliente, String telefone_cliente) {
		super();
		this.id_cliente = id_cliente;
		this.nome_cliente = nome_cliente;
		this.endereco_cliente = endereco_cliente;
		this.cpf_cliente = cpf_cliente;
		this.email_cliente = email_cliente;
		this.telefone_cliente = telefone_cliente;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getEndereco_cliente() {
		return endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getTelefone_cliente() {
		return telefone_cliente;
	}

	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}

	@Override
	public String toString() {
		return this.nome_cliente;
	}

}
