package DAO;

import java.sql.*;
import java.util.ArrayList;
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

    public static void atualizarPedido(Pedido pedido){
        String sql = "UPDATE pedido SET fk_id_cliente = ?, status_pedido = ?, valor_total = ? WHERE id_pedido = ?";

        try(PreparedStatement preparedStatement = conexaoPedido.prepareStatement(sql)){
            preparedStatement.setInt(1, pedido.getCliente().getCpfCliente());
            preparedStatement.setString(2, pedido.getStatusPedido());
            preparedStatement.setDouble(3, pedido.getValorTotal());
            preparedStatement.setInt(4, pedido.getIdPedido());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarPedido(int idPedido){
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        try(PreparedStatement preparedStatement = conexaoPedido.prepareStatement(sql)){
            preparedStatement.setInt(1, idPedido);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Pedido> listarPedido(){
        List<Pedido> listaPedido = new ArrayList<>();
        String sql = "SELECT * FROM pedido";

        try(PreparedStatement preparedStatement = conexaoPedido.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Pedido pedido = mapearResultSetParaPedido(resultSet);
                listaPedido.add(pedido);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaPedido;
    }

    public static List<Pedido> listarPedidoPorCliente(int idCliente){
        List<Pedido> listaPedido = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE fk_id_cliente = ?";

        try(PreparedStatement preparedStatement = conexaoPedido.prepareStatement(sql)){
            preparedStatement.setInt(1, idCliente);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Pedido pedido = mapearResultSetParaPedido(resultSet);
                listaPedido.add(pedido);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaPedido;
    }

    public static Pedido buscarPedidoPorId(int idPedido){
        String sql = "SELECT * FROM pedido WHERE id_pedido = ?";

        try(PreparedStatement preparedStatement = conexaoPedido.prepareStatement(sql)){
            preparedStatement.setInt(1, idPedido);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaPedido(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
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
