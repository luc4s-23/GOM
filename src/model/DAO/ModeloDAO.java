package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import util.Conexao;

public class ModeloDAO {

	public static int obterIdModeloSelecionado(String modelo) {
	    // Esse método deve retornar o id_modelo com base no nome do modelo
	    int idModelo = 0;
	    
	    // Exemplo de lógica para associar o nome do modelo ao id_modelo
	    if (modelo.equals("Modelo A")) {
	        idModelo = 1;  // Substitua pelos valores reais
	    } else if (modelo.equals("Modelo B")) {
	        idModelo = 2;
	    } else if (modelo.equals("Modelo C")) {
	        idModelo = 3;
	    }
	    
	    // Se precisar de uma busca mais dinâmica, pode consultar o banco de dados ou um mapa de modelos
	    return idModelo;
	}
	
	public static JComboBox<String> carregarComboBoxModelo(JComboBox<String> comboModelo, String fabricanteNome) {
		// Limpar todos os itens do combo box antes de adicionar novos
		comboModelo.removeAllItems();

		// Estabelecendo a conexão com o banco de dados
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();
		String sql = "SELECT m.nome FROM modelos m JOIN fabricante f ON m.fk_id_fabricante = f.id_fabricante WHERE f.nome = ?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, fabricanteNome);
			ResultSet rs = comando.executeQuery();

			// Adicionando os clientes ao JComboBox
			while (rs.next()) {
				comboModelo.addItem(rs.getString("nome"));
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
		return comboModelo;
	}
	
}
