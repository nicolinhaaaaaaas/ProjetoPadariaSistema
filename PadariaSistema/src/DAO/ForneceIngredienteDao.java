package DAO;

import java.sql.*;
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

    public static void atualizarForneceIngrediente(){

    }

    public static void deletarForneceIngrediente(){

    }

    public static List<ForneceIngrediente> listarIngredientePorFornecedor(int cnpjFornecedor){

        return null;
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
