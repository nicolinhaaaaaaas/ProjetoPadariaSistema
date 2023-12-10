package DAO;

import java.sql.*;
import java.util.*;
import ENTIDADES.*;

public class ClienteDao {
    private static Connection conexaoCliente;
    
    public ClienteDao(Connection conexaoCliente){
        ClienteDao.conexaoCliente = conexaoCliente;
    }

    public static void inserirCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (cpf_cliente, nome_cliente, login_cliente, senha_cliente, endereco_cliente, contato_cliente) VALUES (?, ?, ?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = conexaoCliente.prepareStatement(sql)){
            preparedStatement.setInt(1, cliente.getCpfCliente());
            preparedStatement.setString(2, cliente.getNomeCliente());
            preparedStatement.setString(3, cliente.getLoginCliente());
            preparedStatement.setString(4, cliente.getSenhaCliente());
            preparedStatement.setString(5, cliente.getEnderecoCliente());
            preparedStatement.setString(6, cliente.getContatoCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarCliente(Cliente cliente){
        String sql = "UPDATE cliente SET nome_cliente = ?, login_cliente = ?, senha_cliente = ?, endereco_cliente = ?, contato_cliente = ? WHERE cpf_cliente = ?;";

        try(PreparedStatement preparedStatement = conexaoCliente.prepareStatement(sql)){
            preparedStatement.setString(1, cliente.getNomeCliente());
            preparedStatement.setString(2, cliente.getLoginCliente());
            preparedStatement.setString(3, cliente.getSenhaCliente());
            preparedStatement.setString(4, cliente.getEnderecoCliente());
            preparedStatement.setString(5, cliente.getContatoCliente());
            preparedStatement.setInt(6, cliente.getCpfCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarCliente(int cpfCliente){
        String sql = "DELETE FROM cliente WHERE cpf_cliente = ?;";

        try(PreparedStatement preparedStatement = conexaoCliente.prepareStatement(sql)){
            preparedStatement.setInt(1, cpfCliente);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> listarCliente(){
        List<Cliente> listaCliente = new ArrayList<>();

        String sql = "SELECT * FROM cliente;";

        try(PreparedStatement preparedStatement = conexaoCliente.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Cliente cliente = mapearResultSetParaCliente(resultSet);
                listaCliente.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCliente;
    }

    public static Cliente buscarClientePorLoginSenha(String login, String senha){
        String sql = "SELECT * FROM cliente WHERE login_cliente = ? AND senha_cliente = ?;";

        try(PreparedStatement preparedStatement = conexaoCliente.prepareStatement(sql)){
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaCliente(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verificarLogin(String login){
        String sql = "SELECT * FROM cliente WHERE login_cliente = ?;";

        try(PreparedStatement preparedStatement = conexaoCliente.prepareStatement(sql)){
            preparedStatement.setString(1, login);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Cliente buscarClientePorCpf(int cpfCliente){
        String sql = "SELECT * FROM cliente WHERE cpf_cliente = ?;";

        try(PreparedStatement preparedStatement = conexaoCliente.prepareStatement(sql)){
            preparedStatement.setInt(1, cpfCliente);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaCliente(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Cliente mapearResultSetParaCliente(ResultSet resultSet)throws SQLException{
        int CpfCliente = resultSet.getInt("cpf_cliente");
        String nomeCliente = resultSet.getString("nome_cliente");
        String loginCliente = resultSet.getString("login_cliente");
        String senhaCliente = resultSet.getString("senha_cliente");
        String enderecoCliente = resultSet.getString("endereco_cliente");
        String contatoCliente = resultSet.getString("contato_cliente");
        
        return new Cliente(CpfCliente, nomeCliente, loginCliente, senhaCliente, enderecoCliente, contatoCliente);
    }
}
