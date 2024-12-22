package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ItensOS;
import util.Conexao;

public class ItensOSDAO {
	public static ItensOS adicionarItem(String descricao, double valorUni, int quantidade) {
		ItensOS item = null;

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "INSERT INTO itens_os (descricao, valor_unitario, quantidade) VALUES (?, ?, ?)";

		try {
			PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			comando.setString(1, descricao);
			comando.setDouble(2, valorUni);
			comando.setInt(3, quantidade);

			if (comando.executeUpdate() > 0) {
				ResultSet rs = comando.getGeneratedKeys();
				if(rs.next()) {					
					int id_item = rs.getInt(1);
					int id_OS = rs.getInt(1);
					item = new ItensOS(id_item, descricao, valorUni, quantidade, id_OS);
				}
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return item;
	}
}
