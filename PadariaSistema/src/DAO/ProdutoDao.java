package DAO;

import java.sql.*;
import java.util.List;

import ENTIDADES.Produto;

public class ProdutoDao {
    private static Connection conexaoProduto;

    public ProdutoDao(Connection conexaoProduto){
        ProdutoDao.conexaoProduto = conexaoProduto;
    }

    public static void inserirProduto(Produto produto){
        String sql = "INSERT INTO produto (nome_produto, descricao_produto, preco_produto, quantidade_produto) VALUES (?, ?, ?, ?)";

        try(PreparedStatement statement = conexaoProduto.prepareStatement(sql)){
            statement.setString(1, produto.getNomeProduto());
            statement.setString(2, produto.getDescricaoProduto());
            statement.setDouble(3, produto.getPrecoProduto());
            statement.setInt(4, produto.getQuantidadeEstoque());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarProduto(){

    }

    public static void deletarProduto(){

    }
    
    public static List<Produto> listarProduto(){

        return null;
    }

    public static Produto buscarProdutoPorId(int idProduto){

        return null;
    }

    public static Produto buscarProdutoPorNome(String nomeProduto){

        return null;
    }

    public static Produto mapearResultSetParaProduto(ResultSet resultSet) throws SQLException{
        int idProduto = resultSet.getInt("id_produto");
        String nomeProduto = resultSet.getString("nome_produto");
        String descricaoProduto = resultSet.getString("descricao_produto");
        double precoProduto = resultSet.getDouble("preco_produto");
        int quantidadeProduto = resultSet.getInt("quantidade_produto");
        
        return new Produto(idProduto, nomeProduto, descricaoProduto, precoProduto, quantidadeProduto);
    }
}
