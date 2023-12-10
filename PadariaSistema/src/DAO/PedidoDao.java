package DAO;

import java.sql.*;
import java.util.List;

import ENTIDADES.Pedido;

public class PedidoDao {
    private static Connection conexaoPedido;

    public PedidoDao(Connection conexaoPedido){
        PedidoDao.conexaoPedido = conexaoPedido;
    }

    public static void inserirPedido(Pedido pedido){
        String sql = "INSERT INTO pedido (fk_id_cliente, status_pedido, valor_total) VALUES (?, ?, ?)";

        try(PreparedStatement statement = conexaoPedido.prepareStatement(sql)){
            statement.setInt(1, pedido.getCliente().getCpfCliente());
            statement.setString(2, pedido.getStatusPedido());
            statement.setDouble(3, pedido.getValorTotal());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarPedido(){

    }

    public static void deletarPedido(){

    }

    public static List<Pedido> listarPedido(){

        return null;
    }

    public static List<Pedido> listarPedidoPorCliente(int idCliente){

        return null;
    }

    public static Pedido buscarPedidoPorId(int idPedido){

        return null;
    }

    public static Pedido mapearResultSetParaPedido(ResultSet resultSet) throws SQLException{
        int idPedido = resultSet.getInt("id_pedido");
        int idCliente = resultSet.getInt("fk_id_cliente");
        String statusPedido = resultSet.getString("status_pedido");
        double valorTotal = resultSet.getDouble("valor_total");

        return new Pedido(idPedido, ClienteDao.buscarClientePorCpf(idCliente), statusPedido, valorTotal);
    }
}
