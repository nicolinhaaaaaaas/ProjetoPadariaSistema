package DAO;

import java.sql.*;
import java.util.ArrayList;
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

    public static void atualizarProdutoIngrediente(ProdutoIngrediente produtoIngrediente){
        String sql = "UPDATE produto_ingrediente SET quantidade_usada = ? WHERE fk_id_produto = ? AND fk_id_ingrediente = ?";

        try(PreparedStatement preparedStatement = conexaoProdutoIngrediente.prepareStatement(sql)){
            preparedStatement.setDouble(1, produtoIngrediente.getQuantidadeUsada());
            preparedStatement.setInt(2, produtoIngrediente.getProduto().getIdProduto());
            preparedStatement.setInt(3, produtoIngrediente.getIngrediente().getIdIngrediente());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();   
        }
    }

    public static void deletarProdutoIngrediente(int idProduto, int idIngrediente){
        String sql = "DELETE FROM produto_ingrediente WHERE fk_id_produto = ? AND fk_id_ingrediente = ?";
        try(PreparedStatement preparedStatement = conexaoProdutoIngrediente.prepareStatement(sql)){
            preparedStatement.setInt(1, idProduto);
            preparedStatement.setInt(2, idIngrediente);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<ProdutoIngrediente> listarProdutoIngrediente(){
        List<ProdutoIngrediente> listaProdutoIngrediente = new ArrayList<>();
        String sql = "SELECT * FROM produto_ingrediente";

        try(PreparedStatement preparedStatement = conexaoProdutoIngrediente.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                listaProdutoIngrediente.add(mapearResultSetParaProdutoIngrediente(resultSet));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaProdutoIngrediente;
    }

    public static List<ProdutoIngrediente> listarProdutoIngredientePorIdProduto(int idProduto){
        List<ProdutoIngrediente> listaIngredientePorProduto = new ArrayList<>();
        String sql = "SELECT * FROM produto_ingrediente WHERE fk_id_produto = ?";

        try(PreparedStatement preparedStatement = conexaoProdutoIngrediente.prepareStatement(sql)){
            preparedStatement.setInt(1, idProduto);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    listaIngredientePorProduto.add(mapearResultSetParaProdutoIngrediente(resultSet));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaIngredientePorProduto;
    }

    public static ProdutoIngrediente mapearResultSetParaProdutoIngrediente(ResultSet resultSet)throws SQLException{
        int idProduto = resultSet.getInt("fk_id_produto");
        int idIngrediente = resultSet.getInt("fk_id_ingrediente");
        double quantidadeUsada = resultSet.getDouble("quantidade_usada");

        return new ProdutoIngrediente(ProdutoDao.buscarProdutoPorId(idProduto), IngredienteDao.buscarIngredientePorId(idIngrediente), quantidadeUsada);
    }
}
