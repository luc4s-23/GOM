package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import util.Conexao;

public class VeiculoDAO {
	private JTable tabelaVeiculos;

	public static Veiculo inserirVeiculo(String placa, String motor, int fk_id_cliente, int fk_id_modelo, String ano) {
		Veiculo veiculo = null;

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "insert into veiculo (placa, motor, fk_id_cliente, fk_id_modelo, ano) values(?,?,?,?,?)";

		try {
			PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			comando.setString(1, placa);
			comando.setString(2, motor);
			comando.setInt(3, fk_id_cliente);
			comando.setInt(4, fk_id_modelo);
			comando.setString(5, ano);

			if (comando.executeUpdate() > 0) {
				ResultSet rs = comando.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					veiculo = new Veiculo(id, placa, motor, fk_id_cliente, fk_id_modelo, ano);

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
		}
		return veiculo;

	}

	public static List<Veiculo> buscarVeiculosPorCliente(int idCliente) {
		List<Veiculo> veiculos = new ArrayList<>();

		// Conexão ao banco de dados
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "SELECT * FROM veiculo WHERE fk_id_cliente = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, idCliente);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setMotor(rs.getString("motor"));
				veiculo.setId_modelo(rs.getInt("fk_id_modelo"));
				veiculos.add(veiculo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return veiculos;

	}

	public boolean existsByPlaca(String placa) {
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "SELECT COUNT(*) FROM veiculo WHERE placa = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, placa); // Define o valor da placa no PreparedStatement
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) > 0; // Se o número de registros encontrados for maior que 0, já existe um veículo
											// com essa placa
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Retorna false caso ocorra algum erro ou se não encontrar a placa
	}

	public static JComboBox<String> carregarNomesVeiculo(JComboBox<String> comboVeiculo, int id_cliente) {
		comboVeiculo.removeAllItems();
		System.out.println("ID Cliente Selecionado: " + id_cliente);

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		// Consulta SQL com JOIN para buscar o nome do modelo associado ao veículo
		String sql = "SELECT modelo.nome " + "FROM veiculo "
				+ "INNER JOIN modelo ON veiculo.fk_id_modelo = modelo.id_modelo " + "WHERE veiculo.fk_id_cliente = ?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id_cliente);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				String nomeVeiculo = rs.getString("nome"); // Nome do modelo do veículo
				comboVeiculo.addItem(nomeVeiculo); // Adiciona apenas o nome ao JComboBox
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao buscar nomes de veículos no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return comboVeiculo;
	}
}