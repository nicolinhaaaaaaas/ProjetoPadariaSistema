package DAO;

import java.sql.*;
import java.util.List;

import ENTIDADES.Gerente;

public class GerenteDao {
    private static Connection conexaoGerente;

    public GerenteDao(Connection conexaoGerente){
        GerenteDao.conexaoGerente = conexaoGerente;
    }

    public static void inserirGerente(Gerente gerente){
        String sql = "INSERT INTO gerente (nome_gerente, login_gerente, senha_gerente) VALUES (?, ?, ?)";

        try(PreparedStatement statement = conexaoGerente.prepareStatement(sql)){
            statement.setString(1, gerente.getNomeGerente());
            statement.setString(2, gerente.getLoginGerente());
            statement.setString(3, gerente.getSenhaGerente());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarGerente(){

    }

    public static void deletarGerente(){

    }

    public static List<Gerente> listarGerente(){

        return null;
    }

    public static Gerente buscarGerentePorId(int idGerente){

        return null;
    }

    public static Gerente buscarGerentePorLoginSenha(String loginGerente, String senhaGerente){

        return null;
    }

    public static boolean verificarLogin(String loginGerente, String senhaGerente){

        return false;
    }

    public static Gerente mapearResultSetParaGerente(ResultSet resultSet) throws SQLException{
        int idGerente = resultSet.getInt("id_gerente");
        String nomeGerente = resultSet.getString("nome_gerente");
        String loginGerente = resultSet.getString("login_gerente");
        String senhaGerente = resultSet.getString("senha_gerente");

        return new Gerente(idGerente, nomeGerente, loginGerente, senhaGerente);
    }
}
