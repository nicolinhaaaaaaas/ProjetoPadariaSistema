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

    public static void atualizarCliente(){

    }

    public static void deletarCliente(){

    }

    public static List<Cliente> listarCliente(){

        return null;
    }

    public static Cliente buscarClientePorLoginSenha(){

        return null;
    }

    public static boolean verificarLogin(){

        return false;
    }

    public static Cliente buscarClientePorCpf(int cpfCliente){

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
