package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import util.Conexao;

public class FabricanteDAO {

	public static JComboBox<String> carregarComboBoxModelo(JComboBox<String> comboFabricante) {
		// Limpar todos os itens do combo box antes de adicionar novos
		comboFabricante.removeAllItems();

		// Estabelecendo a conexão com o banco de dados
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "select nome from fabricante";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();

			// Adicionando os clientes ao JComboBox
			while (rs.next()) {
				comboFabricante.addItem(rs.getString("nome"));
			}

			// Fechando recursos
			rs.close();
			comando.close();
			conexao.fecharConexao(con);

		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();

			// Exibindo uma mensagem de erro
			JOptionPane.showMessageDialog(null, "Ocorreu erro ao carregar a Combo Box", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		return comboFabricante;
	}
}
