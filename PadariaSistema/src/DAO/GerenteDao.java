package DAO;

import java.sql.*;
import java.util.ArrayList;
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

    public static void atualizarGerente(Gerente gerente){
        String sql = "UPDATE gerente SET nome_gerente = ?, login_gerente = ?, senha_gerente = ? WHERE id_gerente = ?";
        try(PreparedStatement preparedStatement = conexaoGerente.prepareStatement(sql)){
            preparedStatement.setString(1, gerente.getNomeGerente());
            preparedStatement.setString(2, gerente.getLoginGerente());
            preparedStatement.setString(3, gerente.getSenhaGerente());
            preparedStatement.setInt(4, gerente.getIdGerente());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarGerente(int idGerente){
        String sql = "DELETE FROM gerente WHERE id_gerente = ?";
        try(PreparedStatement preparedStatement = conexaoGerente.prepareStatement(sql)){
            preparedStatement.setInt(1, idGerente);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Gerente> listarGerente(){
        List<Gerente> listaGerente = new ArrayList<>();
        String sql = "SELECT * FROM gerente";

        try(PreparedStatement preparedStatement = conexaoGerente.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Gerente gerente = mapearResultSetParaGerente(resultSet);
                listaGerente.add(gerente);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaGerente;
    }

    public static Gerente buscarGerentePorId(int idGerente){
        String sql = "SELECT * FROM gerente WHERE id_gerente = ?";

        try(PreparedStatement preparedStatement = conexaoGerente.prepareStatement(sql)){
            preparedStatement.setInt(1, idGerente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaGerente(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Gerente buscarGerentePorLoginSenha(String loginGerente, String senhaGerente){
        String sql = "SELECT * FROM gerente WHERE login_gerente = ? AND senha_gerente = ?";

        try(PreparedStatement preparedStatement = conexaoGerente.prepareStatement(sql)){
            preparedStatement.setString(1, loginGerente);
            preparedStatement.setString(2, senhaGerente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaGerente(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
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
