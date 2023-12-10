package DAO;

import java.sql.*;
import java.util.ArrayList;
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

    public static void atualizarProduto(Produto produto){
        String sql = "UPDATE produto SET nome_produto = ?, descricao_produto = ?, preco_produto = ?, quantidade_produto = ? WHERE id_produto = ?";

        try(PreparedStatement preparedStatement = conexaoProduto.prepareStatement(sql)){
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setString(2, produto.getDescricaoProduto());
            preparedStatement.setDouble(3, produto.getPrecoProduto());
            preparedStatement.setInt(4, produto.getQuantidadeEstoque());
            preparedStatement.setInt(5, produto.getIdProduto());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarProduto(int idProduto){
        String sql = "DELETE FROM produto WHERE id_produto = ?";

        try(PreparedStatement preparedStatement = conexaoProduto.prepareStatement(sql)){
            preparedStatement.setInt(1, idProduto);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static List<Produto> listarProduto(){
        List<Produto> listaProduto = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try(PreparedStatement preparedStatement = conexaoProduto.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Produto produto = mapearResultSetParaProduto(resultSet);
                listaProduto.add(produto);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return listaProduto;
    }

    public static Produto buscarProdutoPorId(int idProduto){
        String sql = "SELECT * FROM produto WHERE id_produto = ?";

        try(PreparedStatement preparedStatement = conexaoProduto.prepareStatement(sql)){
            preparedStatement.setInt(1, idProduto);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaProduto(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Produto buscarProdutoPorNome(String nomeProduto){
        String sql = "SELECT * FROM produto WHERE nome_produto = ?";

        try(PreparedStatement preparedStatement = conexaoProduto.prepareStatement(sql)){
            preparedStatement.setString(1, nomeProduto);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaProduto(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
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
