package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.Configurador;

public class Conexao {
	private String url;
	private String driver;
	private String login;
	private String senha;

	private Conexao(String url, String driver, String login, String senha) {
		super();
		this.url = url;
		this.driver = driver;
		this.login = login;
		this.senha = senha;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar o Driver. Classe não encontrada.");
			System.out.println("Mensagem: " + e.getMessage());
		}
	}
	
	public static Conexao Conectar() {
		Configurador cf = new Configurador();
		return new Conexao(cf.getUrl(), cf.getDriver(), cf.getLogin(), cf.getSenha());
	}

	public Connection obterConexao() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, login, senha);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
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
