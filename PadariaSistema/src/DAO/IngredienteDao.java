package DAO;

import java.sql.*;
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

    public static void atualizarIngrediente(){

    }

    public static void deletarIngrediente(){

    }

    public static List<Ingrediente> listarIngrediente(){

        return null;
    }

    public static List<Ingrediente> listarIngredientePorMedida(String unidadeMedida){

        return null;
    }

    public static Ingrediente buscarIngredientePorId(int idIngrediente){

        return null;
    }

    public static Ingrediente buscarIngredientePorNome(String nomeIngrediente){

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
