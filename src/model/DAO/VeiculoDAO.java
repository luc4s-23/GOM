package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
