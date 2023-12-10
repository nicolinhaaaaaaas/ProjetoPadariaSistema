package DAO;

import java.sql.*;
import java.util.ArrayList;
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

    public static void atualizarFuncionario(Funcionario funcionario){
        String sql = "UPDATE funcionario SET nome_funcionario = ?, telefone_funcionario = ?, email_funcionario = ?, cargo_funcionario = ?, salario_funcionario = ? WHERE id_funcionario = ?";

        try(PreparedStatement preparedStatement = conexaoFuncionario.prepareStatement(sql)){
            preparedStatement.setString(1, funcionario.getNomeFuncionario());
            preparedStatement.setString(2, funcionario.getTelefoneFuncionario());
            preparedStatement.setString(3, funcionario.getEmailFuncionario());
            preparedStatement.setString(4, funcionario.getCargoFuncionario());
            preparedStatement.setDouble(5, funcionario.getSalarioFuncionario());
            preparedStatement.setInt(6, funcionario.getIdFuncionario());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarFuncionario(int idFuncionario){
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        try(PreparedStatement preparedStatement = conexaoFuncionario.prepareStatement(sql)){
            preparedStatement.setInt(1, idFuncionario);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Funcionario> listarFuncionario(){
        List<Funcionario> listaFuncionario = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try(PreparedStatement preparedStatement = conexaoFuncionario.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Funcionario funcionario = mapearResultSetParaFuncionario(resultSet);
                listaFuncionario.add(funcionario);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaFuncionario;
    }

    public static List<Funcionario> listarFuncionarioPorCargo(String cargoFuncionario){
        List<Funcionario> listaFuncionarioCargo = new ArrayList<>();
        String sql = "SELECT * FROM funcionario WHERE cargo_funcionario = ?";

        try(PreparedStatement preparedStatement = conexaoFuncionario.prepareStatement(sql)){
            preparedStatement.setString(1, cargoFuncionario);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    listaFuncionarioCargo.add(mapearResultSetParaFuncionario(resultSet));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaFuncionarioCargo;
    }

    public static Funcionario buscarFuncionarioPorId(int idFuncionario){
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";

        try(PreparedStatement preparedStatement = conexaoFuncionario.prepareStatement(sql)){
            preparedStatement.setInt(1, idFuncionario);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return mapearResultSetParaFuncionario(resultSet);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
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
