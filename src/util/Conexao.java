package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String url;
	private String driver;
	private String login;
	private String senha;
	
	public Conexao(String url, String driver, String login, String senha) {
		super();
		this.url = url;
		this.driver = driver;
		this.login = login;
		this.senha = senha;
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			System.out.println("Erro ao carregar o Driver. Classe não encontrada.");
			System.out.println("Mensagem: "+e.getMessage());
		}
	}
	
	public Connection obterConexao() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url,login,senha);
		}catch(SQLException e) {
			System.out.println("Erro ao acessar o Banco de Dados.");
			System.out.println("Verifique os parâmetros de conexão.");
			System.out.println("Mensagem: "+e.getMessage());
		}
		
		return con;
	}

	public String getUrl() {
		return url;
	}

	public String getDriver() {
		return driver;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	
	
	
	
}
