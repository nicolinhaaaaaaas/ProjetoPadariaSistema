package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.Ingrediente;

public class IngredienteDao {
    private static Connection conexaoIngrediente;

    public IngredienteDao(Connection conexaoIngrediente){
        IngredienteDao.conexaoIngrediente = conexaoIngrediente;
    }

    public static void inserirIngrediente(Ingrediente ingrediente){
        String sql = "INSERT INTO ingrediente (nome_ingrediente, quantidade_estoque, unidade_medida) VALUES (?, ?, ?)";

        try(PreparedStatement statement = conexaoIngrediente.prepareStatement(sql)){
            statement.setString(1, ingrediente.getNomeIngrediente());
            statement.setInt(2, ingrediente.getQuantidadeEstoque());
            statement.setString(3, ingrediente.getUnidadeMedida());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarIngrediente(Ingrediente ingrediente){
        String sql = "UPDATE ingrediente SET nome_ingrediente = ?, quantidade_estoque = ?, unidade_medida = ? WHERE id_ingrediente = ?";

        try(PreparedStatement preparedStatement = conexaoIngrediente.prepareStatement(sql)){
            preparedStatement.setString(1, ingrediente.getNomeIngrediente());
            preparedStatement.setInt(2, ingrediente.getQuantidadeEstoque());
            preparedStatement.setString(3, ingrediente.getUnidadeMedida());
            preparedStatement.setInt(4, ingrediente.getIdIngrediente());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarIngrediente(int idIngrediente){
        String sql = "DELETE FROM ingrediente WHERE id_ingrediente = ?";

        try(PreparedStatement preparedStatement = conexaoIngrediente.prepareStatement(sql)){
            preparedStatement.setInt(1, idIngrediente);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Ingrediente> listarIngrediente(){
        List<Ingrediente> listaIngrediente = new ArrayList<>();
        String sql = "SELECT * FROM ingrediente";

        try(PreparedStatement preparedStatement = conexaoIngrediente.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Ingrediente ingrediente = mapearResultSetParaIngrediente(resultSet);
                listaIngrediente.add(ingrediente);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaIngrediente;
    }

    public static List<Ingrediente> listarIngredientePorMedida(String unidadeMedida){
        List<Ingrediente> listaIngrediente = new ArrayList<>();
        String sql = "SELECT * FROM ingrediente WHERE unidade_medida = ?";

        try(PreparedStatement preparedStatement = conexaoIngrediente.prepareStatement(sql)){
            preparedStatement.setString(1, unidadeMedida);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    listaIngrediente.add(mapearResultSetParaIngrediente(resultSet));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaIngrediente;
    }

    public static Ingrediente buscarIngredientePorId(int idIngrediente){
        String sql = "SELECT * FROM ingrediente WHERE id_ingrediente = ?";

        try(PreparedStatement preparedStatement = conexaoIngrediente.prepareStatement(sql)){
            preparedStatement.setInt(1, idIngrediente);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaIngrediente(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Ingrediente buscarIngredientePorNome(String nomeIngrediente){
        String sql = "SELECT * FROM ingrediente WHERE nome_ingrediente = ?";

        try(PreparedStatement preparedStatement = conexaoIngrediente.prepareStatement(sql)){
            preparedStatement.setString(1, nomeIngrediente);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaIngrediente(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Ingrediente mapearResultSetParaIngrediente(ResultSet resultSet) throws SQLException{
        int idIngrediente = resultSet.getInt("id_ingrediente");
        String nomeIngrediente = resultSet.getString("nome_ingrediente");
        int quantidadeEstoque = resultSet.getInt("quantidade_estoque");
        String unidadeMedida = resultSet.getString("unidade_medida");       

        return new Ingrediente(idIngrediente, nomeIngrediente, quantidadeEstoque, unidadeMedida);
    }
}
