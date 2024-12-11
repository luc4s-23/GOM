package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Cliente;
import util.Conexao;

public class ClienteDAO {

	public static Cliente inserir(String nome, String endereco, String cpf, String email, String telefone,
			JComboBox<String> comboCliente) {

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
				carregarComboBoxCliente(comboCliente);
			}

			comando.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return cliente;
	}

	public static JComboBox<String> carregarComboBoxCliente(JComboBox<String> comboCliente) {
		comboCliente.removeAllItems();

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "select * from cliente";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				comboCliente.addItem(rs.getString("nomeCompleto_cliente"));
			}

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

	public static List<String> buscarNomesClientes() {
		List<String> nomes = new LinkedList<String>();

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "select DISTINCT nomeCompleto_cliente from cliente";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				nomes.add(rs.getString("nomeCompleto_cliente"));
			}
			rs.close();
			comando.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return nomes;
	}

	public static boolean excluir(int id) {
		boolean ok = false;

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);

			ok = comando.executeUpdate() > 0;

			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao excluir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return ok;
	}

	public static boolean atualizar(int id, String nome, String endereco, String cpf, String email, String telefone) {
		boolean ok = false;

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "UPDATE cliente SET nome_cliente = ?, endereco_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? WHERE id_cliente = ?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, nome);
			comando.setString(2, endereco);
			comando.setString(3, cpf);
			comando.setString(4, email);
			comando.setString(5, telefone);
			comando.setInt(6, id);

			ok = comando.executeUpdate() > 0;

			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return ok;
	}

}
