package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.ForneceIngrediente;

public class ForneceIngredienteDao {
    private static Connection conexaoForneceIngrediente;

    public ForneceIngredienteDao(Connection conexaoForneceIngrediente){
        ForneceIngredienteDao.conexaoForneceIngrediente = conexaoForneceIngrediente;
    }

    public static void inserirForneceIngrediente(ForneceIngrediente forneceIngrediente){
        String sql = "INSERT INTO fornece_ingrediente (fk_cnpj_fornecedor, fk_id_ingrediente, preco_ingrediente, data_fornecimento, quantidade_fornecida) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement statement = conexaoForneceIngrediente.prepareStatement(sql)){
            statement.setString(1, forneceIngrediente.getFornecedor().getCNPJ());
            statement.setInt(2, forneceIngrediente.getIngrediente().getIdIngrediente());
            statement.setDouble(3, forneceIngrediente.getPrecoIngrediente());
            statement.setString(4, forneceIngrediente.getDataFornecimento());
            statement.setInt(5, forneceIngrediente.getQuantidadeComprada());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarForneceIngrediente(ForneceIngrediente forneceIngrediente){
        String sql = "UPDATE fornece_ingrediente SET preco_ingrediente = ?, data_fornecimento = ?, quantidade_fornecida = ? WHERE fk_cnpj_fornecedor = ? AND fk_id_ingrediente = ?";
        try(PreparedStatement preparedStatement = conexaoForneceIngrediente.prepareStatement(sql)){
            preparedStatement.setDouble(1, forneceIngrediente.getPrecoIngrediente());
            preparedStatement.setString(2, forneceIngrediente.getDataFornecimento());
            preparedStatement.setInt(3, forneceIngrediente.getQuantidadeComprada());
            preparedStatement.setString(4, forneceIngrediente.getFornecedor().getCNPJ());
            preparedStatement.setInt(5, forneceIngrediente.getIngrediente().getIdIngrediente());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarForneceIngrediente(String cnpjFornecedor, int idIngrediente){
        String sql = "DELETE FROM fornece_ingrediente WHERE fk_cnpj_fornecedor = ? AND fk_id_ingrediente = ?";
        try(PreparedStatement preparedStatement = conexaoForneceIngrediente.prepareStatement(sql)){
            preparedStatement.setString(1, cnpjFornecedor);
            preparedStatement.setInt(2, idIngrediente);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<ForneceIngrediente> listarIngredientePorFornecedor(int cnpjFornecedor){
        List<ForneceIngrediente> listaForneceIngrediente = new ArrayList<>();
        String sql = "SELECT * FROM fornece_ingrediente WHERE fk_cnpj_fornecedor = ?";

        try(PreparedStatement preparedStatement = conexaoForneceIngrediente.prepareStatement(sql)){
            preparedStatement.setInt(1, cnpjFornecedor);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    listaForneceIngrediente.add(mapearResultSetParaForneceIngrediente(resultSet));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaForneceIngrediente;
    }

    public static ForneceIngrediente mapearResultSetParaForneceIngrediente(ResultSet resultSet)throws SQLException{
        String CnpjFornecedor = resultSet.getString("fk_cnpj_fornecedor");
        int idIngrediente = resultSet.getInt("fk_id_ingrediente");
        double precoIngrediente = resultSet.getDouble("preco_ingrediente");
        String dataFornecimento = resultSet.getString("data_fornecimento");
        int quantidadeFornecida = resultSet.getInt("quantidade_fornecida");

        return new ForneceIngrediente(FornecedorDao.buscarFornecedorPorCnpj(CnpjFornecedor), IngredienteDao.buscarIngredientePorId(idIngrediente), precoIngrediente, dataFornecimento, quantidadeFornecida);
    }
}
