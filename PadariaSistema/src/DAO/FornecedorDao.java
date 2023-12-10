package DAO;

import java.sql.*;
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

    public static void atualizarFornecedor(){

    }

    public static void deletarFornecedor(){

    }

    public static List<Fornecedor> listarFornecedor(){

        return null;
    }

    public static Fornecedor buscarFornecedorPorCnpj(String cnpjFornecedor){

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
