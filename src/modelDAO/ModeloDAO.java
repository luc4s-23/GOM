package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import model.Modelo;
import util.Conexao;

public class ModeloDAO {

	public static JComboBox<Modelo> carregarModelo(JComboBox<Modelo> comboModelo, int id_fabricante) {
		comboModelo.removeAllItems();
		System.out.println(id_fabricante);
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "select * from modelo where fk_id_fabricante=?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id_fabricante);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				Modelo modelo = new Modelo();
				modelo.setId_modelo(rs.getInt("id_modelo"));
				modelo.setFk_id_fabricante(rs.getInt("fk_id_fabricante"));
				modelo.setNome_modelo(rs.getString("nome"));
				comboModelo.addItem(modelo);

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
		return comboModelo;
	}
}