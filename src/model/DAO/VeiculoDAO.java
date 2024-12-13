package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Veiculo;
import util.Conexao;

public class VeiculoDAO {

	public Veiculo inserirVeiculo(String placa, String motor, int fk_id_cliente, int fk_id_modelo) {
		Veiculo veiculo = null;

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "insert into veiculo (placa, motor, fk_id_cliente, fk_id_modelo) values(?,?,?,?)";

		try {
			PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			comando.setString(1, placa);
			comando.setString(2, motor);
			comando.setInt(3, fk_id_cliente);
			comando.setInt(4, fk_id_modelo);

			if (comando.executeUpdate() > 0) {
				ResultSet rs = comando.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					veiculo = new Veiculo(id, placa, motor, fk_id_cliente, fk_id_modelo);

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
	
	public List<Veiculo> buscarVeiculosPorCliente(int idCliente) {
	    List<Veiculo> veiculos = new ArrayList<>();

	    Conexao conexao = Conexao.Conectar();
	    Connection con = conexao.obterConexao();

	    String sql = "SELECT v.*, m.descricao_modelo AS modelo " +
	                 "FROM veiculo v " +
	                 "JOIN modelo m ON v.fk_id_modelo = m.id_modelo " +
	                 "WHERE v.fk_id_cliente = ?";
	    try (PreparedStatement comando = con.prepareStatement(sql)) {
	        comando.setInt(1, idCliente);
	        ResultSet rs = comando.executeQuery();
	        while (rs.next()) {
	            Veiculo veiculo = new Veiculo();
	            veiculo.setPlaca(rs.getString("placa"));
	            veiculo.setMotor(rs.getString("motor"));
	            veiculo.setId_modelo(rs.getInt("id_modelo"));
	            veiculo.setAno(rs.getInt("ano"));
	            veiculos.add(veiculo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return veiculos;
	}
	
}
