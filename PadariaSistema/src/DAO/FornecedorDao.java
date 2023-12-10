package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.Fornecedor;

public class FornecedorDao {
    private static Connection conexaoFornecedor;

    public FornecedorDao(Connection conexaoFornecedor){
        FornecedorDao.conexaoFornecedor = conexaoFornecedor;
    }

    public static void inserirFornecedor(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor (cnpj_fornecedor, nome_fornecedor, telefone_fornecedor, email_fornecedor, local_fornecedor) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement statement = conexaoFornecedor.prepareStatement(sql)){
            statement.setString(1, fornecedor.getCNPJ());
            statement.setString(2, fornecedor.getNomeFornecedor());
            statement.setString(3, fornecedor.getTelefoneFornecedor());
            statement.setString(4, fornecedor.getEmailFornecedor());
            statement.setString(5, fornecedor.getLocalFornecedor());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarFornecedor(Fornecedor fornecedor){
        String sql = "UPDATE fornecedor SET nome_fornecedor = ?, telefone_fornecedor = ?, email_fornecedor = ?, local_fornecedor = ? WHERE cnpj_fornecedor = ?";

        try(PreparedStatement preparedStatement = conexaoFornecedor.prepareStatement(sql)){
            preparedStatement.setString(1, fornecedor.getNomeFornecedor());
            preparedStatement.setString(2, fornecedor.getTelefoneFornecedor());
            preparedStatement.setString(3, fornecedor.getEmailFornecedor());
            preparedStatement.setString(4, fornecedor.getLocalFornecedor());
            preparedStatement.setString(5, fornecedor.getCNPJ());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarFornecedor(String cnpjFornecedor){
        String sql = "DELETE FROM fornecedor WHERE cnpj_fornecedor = ?";

        try(PreparedStatement preparedStatement = conexaoFornecedor.prepareStatement(sql)){
            preparedStatement.setString(1, cnpjFornecedor);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Fornecedor> listarFornecedor(){
        List<Fornecedor> listaFornecedor = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";

        try(PreparedStatement preparedStatement = conexaoFornecedor.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Fornecedor fornecedor = mapearResultSetParaFornecedor(resultSet);
                listaFornecedor.add(fornecedor);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaFornecedor;
    }

    public static Fornecedor buscarFornecedorPorCnpj(String cnpjFornecedor){
        String sql = "SELECT * FROM fornecedor WHERE cnpj_fornecedor = ?";

        try(PreparedStatement preparedStatement = conexaoFornecedor.prepareStatement(sql)){
            preparedStatement.setString(1, cnpjFornecedor);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaFornecedor(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    

    public static Fornecedor mapearResultSetParaFornecedor(ResultSet resultSet)throws SQLException{
        String CnpjFornecedor = resultSet.getString("cnpj_fornecedor");
        String nomeFornecedor = resultSet.getString("nome_fornecedor");
        String telefoneFornecedor = resultSet.getString("telefone_fornecedor");
        String emailFornecedor = resultSet.getString("email_fornecedor");
        String localFornecedor = resultSet.getString("local_fornecedor");

        return new Fornecedor(CnpjFornecedor, nomeFornecedor, telefoneFornecedor, emailFornecedor, localFornecedor);
    }
}
