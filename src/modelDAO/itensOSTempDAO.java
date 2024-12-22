package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ItensOS;
import util.Conexao;

public class itensOSTempDAO {

    public static void adicionarItemTemp(ItensOS item) {
        String sql = "INSERT INTO itens_os_temp (descricao, valor_unitario, quantidade) VALUES (?, ?, ?)";

        try (Connection con = Conexao.Conectar().obterConexao();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, item.getDescricao());
            pst.setDouble(2, item.getValor_unitario());
            pst.setInt(3, item.getQuantidade());

            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void vincularItensAO(int id_OS) {
        String sql = "UPDATE itens_os_temp SET fk_id_OS = ? WHERE fk_id_OS IS NULL";

        try (Connection con = Conexao.Conectar().obterConexao();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id_OS);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Move os itens temporários para a tabela definitiva
        String moveSql = "INSERT INTO itens_os (descricao, valor_unitario, quantidade, fk_id_OS) "
                       + "SELECT descricao, valor_unitario, quantidade, fk_id_OS FROM itens_os_temp WHERE fk_id_OS = ?";

        try (Connection con = Conexao.Conectar().obterConexao();
             PreparedStatement pst = con.prepareStatement(moveSql)) {
            pst.setInt(1, id_OS);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Limpa os itens temporários após a migração
        String deleteSql = "DELETE FROM itens_os_temp WHERE fk_id_OS = ?";

        try (Connection con = Conexao.Conectar().obterConexao();
             PreparedStatement pst = con.prepareStatement(deleteSql)) {
            pst.setInt(1, id_OS);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
