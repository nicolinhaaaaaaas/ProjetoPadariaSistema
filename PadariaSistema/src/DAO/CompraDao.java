package DAO;

import java.sql.*;
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

    public static void atualizarCompra(){

    }

    public static void deletarCompra(){

    }

    public static List<Compra> listarCompra(){

        return null;
    }

    public static Compra mapearResultSetParaCompra(ResultSet resultSet) throws SQLException{
        int idPedido = resultSet.getInt("fk_id_pedido");
        int idProduto = resultSet.getInt("fk_id_produto");
        int quantidadeComprada = resultSet.getInt("quantidade_comprada");

        return new Compra(idPedido, idProduto, quantidadeComprada);
    }
}
