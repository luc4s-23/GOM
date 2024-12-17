package modelDAO;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Cliente;
import util.Conexao;

public class ClienteDAO {

	public static Cliente inserir(String nome, String endereco, String cpf, String email, String telefone) {

		Cliente cliente = null;
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "INSERT INTO cliente (nomeCompleto_cliente, endereco_cliente, cpf_cliente, email_cliente, telefone_cliente) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			comando.setString(1, nome);
			comando.setString(2, endereco);
			comando.setString(3, cpf);
			comando.setString(4, email);
			comando.setString(5, telefone);

			if (comando.executeUpdate() > 0) {
				ResultSet rs = comando.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					cliente = new Cliente(id, nome, endereco, cpf, email, telefone);
				}
				rs.close();
			}

			comando.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();

			// Verifica se o erro é de duplicação (violação de chave única)
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "Dados incorretos ou duplicados!", null, JOptionPane.ERROR_MESSAGE);
				//System.out.println("Erro de integridade no banco de dados (provavelmente duplicação).");
			}
		}
		return cliente;
	}

	public static JComboBox<Cliente> carregarComboBoxCliente(JComboBox<Cliente> comboCliente) {
		comboCliente.removeAllItems();

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "select * from cliente";

		try {
			//PreparedStatement comando = con.prepareStatement(sql);
			Statement comando = con.createStatement();
			ResultSet rs = comando.executeQuery(sql);

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome_cliente(rs.getString("nomeCompleto_cliente"));
				comboCliente.addItem(cliente);
			}
			comboCliente.setSelectedIndex(-1);
			rs.close();
			comando.close();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Ocorreu erro ao carregar a Combo Box", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		return comboCliente;
	}

	public static Cliente consultarCliente(int idCliente) {
		Cliente cliente = null;

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "select * from cliente where id_cliente=?";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, idCliente);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome_cliente(rs.getString("nomeCompleto_cliente"));
				cliente.setEndereco_cliente(rs.getString("endereco_cliente"));
				cliente.setCpf_cliente(rs.getString("cpf_cliente"));
				cliente.setEmail_cliente(rs.getString("email_cliente"));
				cliente.setTelefone_cliente(rs.getString("telefone_cliente"));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Ocorreu erro ao carregar a Combo Box", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		return cliente;
	}
	
	public static boolean deletarCliente (int idCliente) {
		boolean ok = false;
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		
		String sql = "delete from cliente where id_cliente=?";
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, idCliente);
			
			ok = comando.executeUpdate() > 0;
			
			comando.close();
			con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir no Banco de Dados.");
//			System.out.println("Erro ao excluir no Banco de Dados.");
//			System.out.println("Verifique sua instrução SQL.");
//			System.out.println("Mensagem de erro: "+e.getMessage());
//			e.printStackTrace();
		}
		return ok;
	}

	public static boolean atualizar(int id, String nome, String endereco, String cpf, String email, String telefone) {
	    boolean ok = false;

	    Conexao conexao = Conexao.Conectar();
	    Connection con = conexao.obterConexao();

	    String sql = "UPDATE cliente SET nomeCompleto_cliente = ?, endereco_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? WHERE id_cliente = ?";

	    try (PreparedStatement comando = con.prepareStatement(sql)) {
	        comando.setString(1, nome);
	        comando.setString(2, endereco);
	        comando.setString(3, cpf);
	        comando.setString(4, email);
	        comando.setString(5, telefone);
	        comando.setInt(6, id);

	        ok = comando.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ok;
	}
	
	public static boolean existsByCPF(String cpf) {
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "SELECT COUNT(*) FROM cliente WHERE cpf_cliente = ?";

		try (
			PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, cpf); // Define o valor da placa no PreparedStatement
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) > 0; // Se o número de registros encontrados for maior que 0, já existe uma pessoa
											// com esse cpf
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Retorna false caso ocorra algum erro ou se não encontrar a placa
	}
}

