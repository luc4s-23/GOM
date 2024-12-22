package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.Conexao;

public class OSDAO {
	public static int criarOrdemDeServico(int idVeiculo, String formaPagamento, double valorTotal) {
		int id_OS = 0;
		Conexao conexao = Conexao.Conectar();
		Connection con = conexao.obterConexao();

		String sql = "INSERT INTO ordem_de_servico (fk_id_veiculo, forma_pagamento, valor_total) VALUES (?,?,?)";

		try (PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, idVeiculo);
			pst.setString(2, formaPagamento);
			pst.setDouble(3, valorTotal);

			if (pst.executeUpdate() > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					id_OS = rs.getInt(1);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return id_OS;
	}
	
	public static void atualizarTabelaOS(int idCliente, JTable suaTabela) {
		String sql = "SELECT i.quantidade, i.descricao, i.valor_unitario, os.valor_total, v.placa AS modelo, "
				+ "os.forma_pagamento FROM  ordem_de_servico os "
				+ "JOIN veiculo v ON os.fk_id_veiculo = v.id_carro JOIN "
				+ "itens_os i ON i.fk_id_OS = os.id_OS WHERE v.fk_id_cliente = ?";

		DefaultTableModel model = (DefaultTableModel) suaTabela.getModel();
		model.setRowCount(0); // Limpa a tabela

		try (Connection con = Conexao.Conectar().obterConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, idCliente); // Define o ID do cliente na consulta
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] {rs.getInt("quantidade"), rs.getString("descricao"),
						rs.getDouble("valor_unitario"), rs.getDouble("valor_total"), rs.getString("modelo"),
						rs.getString("forma_pagamento") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}


}