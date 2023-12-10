package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.Compra;

public class CompraDao {
    private static Connection conexaoCompra;

    public CompraDao(Connection conexaoCompra){
        CompraDao.conexaoCompra = conexaoCompra;
    }

    public static void inserirCompra(Compra compra){
        String sql = "INSERT INTO compra (fk_id_pedido, fk_id_produto, quantidade_comprada) VALUES (?, ?, ?)";

        try(PreparedStatement statement = conexaoCompra.prepareStatement(sql)){
            statement.setInt(1, compra.getIdPedido());
            statement.setInt(2, compra.getIdProduto());
            statement.setInt(3, compra.getQuantidadeComprada());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarCompra(Compra compra){
        String sql = "UPDATE compra SET quantidade_comprada = ? WHERE fk_id_pedido = ? AND fk_id_produto = ?;";

        try(PreparedStatement preparedStatement = conexaoCompra.prepareStatement(sql)){
            preparedStatement.setInt(1, compra.getQuantidadeComprada());
            preparedStatement.setInt(2, compra.getIdPedido());
            preparedStatement.setInt(3, compra.getIdProduto());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarCompra(Compra compra){
        String sql = "DELETE FROM compra WHERE fk_id_pedido = ? AND fk_id_produto = ?;";

        try(PreparedStatement preparedStatement = conexaoCompra.prepareStatement(sql)){
            preparedStatement.setInt(1, compra.getIdPedido());
            preparedStatement.setInt(2, compra.getIdProduto());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Compra> listarCompra(){
        List<Compra> listaCompra = new ArrayList<>();
        String sql = "SELECT * FROM compra;";

        try(PreparedStatement preparedStatement = conexaoCompra.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Compra compra = mapearResultSetParaCompra(resultSet);
                listaCompra.add(compra);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaCompra;
    }

    public static Compra mapearResultSetParaCompra(ResultSet resultSet) throws SQLException{
        int idPedido = resultSet.getInt("fk_id_pedido");
        int idProduto = resultSet.getInt("fk_id_produto");
        int quantidadeComprada = resultSet.getInt("quantidade_comprada");

        return new Compra(idPedido, idProduto, quantidadeComprada);
    }
}
