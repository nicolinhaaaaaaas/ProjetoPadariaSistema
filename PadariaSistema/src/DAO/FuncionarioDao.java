package DAO;

import java.sql.*;
import java.util.List;

import ENTIDADES.Funcionario;

public class FuncionarioDao {
    private static Connection conexaoFuncionario;

    public FuncionarioDao(Connection conexaoFuncionario){
        FuncionarioDao.conexaoFuncionario = conexaoFuncionario;
    }

    public static void inserirFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionario (nome_funcionario, telefone_funcionario, email_funcionario, cargo_funcionario, salario_funcionario) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement statement = conexaoFuncionario.prepareStatement(sql)){
            statement.setString(1, funcionario.getNomeFuncionario());
            statement.setString(2, funcionario.getTelefoneFuncionario());
            statement.setString(3, funcionario.getEmailFuncionario());
            statement.setString(4, funcionario.getCargoFuncionario());
            statement.setDouble(5, funcionario.getSalarioFuncionario());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarFuncionario(){

    }

    public static void deletarFuncionario(){

    }

    public static List<Funcionario> listarFuncionario(){

        return null;
    }

    public static List<Funcionario> listarFuncionarioPorCargo(String cargoFuncionario){

        return null;
    }

    public static Funcionario buscarFuncionarioPorId(int idFuncionario){

        return null;
    }

    public static Funcionario mapearResultSetParaFuncionario(ResultSet resultSet)throws SQLException{
        int idFuncionario = resultSet.getInt("id_funcionario");
        String nomeFuncionario = resultSet.getString("nome_funcionario");
        String telefoneFuncionario = resultSet.getString("telefone_funcionario");
        String emailFuncionario = resultSet.getString("email_funcionario");
        String cargoFuncionario = resultSet.getString("cargo_funcionario");
        double salarioFuncionaro = resultSet.getDouble("salario_funcionario");

        return new Funcionario(idFuncionario, nomeFuncionario, telefoneFuncionario, emailFuncionario, cargoFuncionario, salarioFuncionaro);
    }
}
