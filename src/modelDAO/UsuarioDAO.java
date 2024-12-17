package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.Conexao;

public class UsuarioDAO {
    private Conexao conexao;

    public UsuarioDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    public boolean autenticar(String login, String senha) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        try (Connection con = conexao.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); 
        } catch (Exception e) {
            System.out.println("Erro ao autenticar o usuário.");
            System.out.println("Mensagem: " + e.getMessage());
            return false;
        }
    }
}