package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Fabricante;
import model.Modelo;
import util.Conexao;

public class FabricanteDAO {

	public static JComboBox<Fabricante> carregarComboBoxFabricante(JComboBox<Fabricante> comboFabricante) {
		// Limpar todos os itens do combo box antes de adicionar novos
		comboFabricante.removeAllItems();

		// Estabelecendo a conexão com o banco de dados
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "select * from fabricante order by nome";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();

			// Adicionando os clientes ao JComboBox
			while (rs.next()) {
				Fabricante fabricante = new Fabricante();
				fabricante.setId_fabricante(rs.getInt("id_fabricante"));
				fabricante.setNome_fabricante(rs.getString("nome"));
				comboFabricante.addItem(fabricante);
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
