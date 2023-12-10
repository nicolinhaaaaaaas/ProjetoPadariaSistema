package DAO;

import java.sql.*;
import java.util.List;

import ENTIDADES.ProdutoIngrediente;

public class ProdutoIngredienteDao {
    private static Connection conexaoProdutoIngrediente;

    public ProdutoIngredienteDao(Connection conexaoProdutoIngrediente){
        ProdutoIngredienteDao.conexaoProdutoIngrediente = conexaoProdutoIngrediente;
    }

    public static void inserirProdutoIngrediente(ProdutoIngrediente produtoIngrediente){
        String sql = "INSERT INTO produto_ingrediente (fk_id_produto, fk_id_ingrediente, quantidade_usada) VALUES (?, ?, ?)";

        try(PreparedStatement statement = conexaoProdutoIngrediente.prepareStatement(sql)){
            statement.setInt(1, produtoIngrediente.getProduto().getIdProduto());
            statement.setInt(2, produtoIngrediente.getIngrediente().getIdIngrediente());
            statement.setDouble(3, produtoIngrediente.getQuantidadeUsada());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarProdutoIngrediente(){

    }

    public static void deletarProdutoIngrediente(){

    }

    public static List<ProdutoIngrediente> listarProdutoIngrediente(){

        return null;
    }

    public static List<ProdutoIngrediente> listarProdutoIngredientePorIdProduto(int idProduto){

        return null;
    }

    public static ProdutoIngrediente mapearResultSetParaProdutoIngrediente(ResultSet resultSet)throws SQLException{
        int idProduto = resultSet.getInt("fk_id_produto");
        int idIngrediente = resultSet.getInt("fk_id_ingrediente");
        double quantidadeUsada = resultSet.getDouble("quantidade_usada");

        return new ProdutoIngrediente(ProdutoDao.buscarProdutoPorId(idProduto), IngredienteDao.buscarIngredientePorId(idIngrediente), quantidadeUsada);
    }
}
