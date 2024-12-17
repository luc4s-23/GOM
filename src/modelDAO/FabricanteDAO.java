package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Fabricante;
import model.Modelo;
import util.Conexao;

public class FabricanteDAO {

	public static JComboBox<Fabricante> carregarComboBoxFabricante(JComboBox<Fabricante> comboFabricante) {
		comboFabricante.removeAllItems();

		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "select * from fabricante order by nome";

		try {
			//PreparedStatement comando = con.prepareStatement(sql);
			Statement comando = con.createStatement();
			ResultSet rs = comando.executeQuery(sql);

			while (rs.next()) {
				Fabricante fabricante = new Fabricante();
				fabricante.setId_fabricante(rs.getInt("id_fabricante"));
				fabricante.setNome_fabricante(rs.getString("nome"));
				comboFabricante.addItem(fabricante);
			}
			comboFabricante.setSelectedIndex(-1);

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Ocorreu erro ao carregar a Combo Box", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		return comboFabricante;
	}
	
	
}
