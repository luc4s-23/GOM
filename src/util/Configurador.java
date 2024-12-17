package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configurador {
	private String url;
	private String driver;
	private String login;
	private String senha;
	
	public Configurador() {
		try {
			FileInputStream arquivo = new FileInputStream("config.ini");
			
			Properties propriedades = new Properties();
			
			propriedades.load(arquivo);
			
			arquivo.close();
			
			this.url = propriedades.getProperty("url");
			this.driver = propriedades.getProperty("driver");
			this.login = propriedades.getProperty("login");
			this.senha = propriedades.getProperty("senha");
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao abrir arquivo config.ini ou arquivo inexistente.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro ao manipular o arquivo de configurações ou configurações inconsistentes.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
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

	@Override
	public String toString() {
		return "Configurador [url=" + url + ", driver=" + driver + ", login=" + login + ", senha=" + senha + "]";
	}
	
	

}
