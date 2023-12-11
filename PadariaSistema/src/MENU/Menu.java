package MENU;

import java.util.*;

import ENTIDADES.*;
import SERVICOS.*;

public class Menu {
    
    // OPÇÕES CLIENTE /////////////////////////////////////////////////////////////////

    public static void cadastroCliente(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite o nome do cliente: ");
            String nome = entrada.nextLine();
            System.out.println("Digite o CPF do cliente: ");
            String cpf = entrada.nextLine();
            System.out.println("Digite o login do cliente: ");
            String login = entrada.nextLine();
            System.out.println("Digite a senha do cliente: ");
            String senha = entrada.nextLine();
            System.out.println("Digite o endereço do cliente: ");
            String endereco = entrada.nextLine();
            System.out.println("Digite o contato do cliente: ");
            String contato = entrada.nextLine();

            if(ClienteServico.verificarLogin(login) == false){
                System.out.println("Login já existente, tente novamente.");
            }else{
                Cliente cliente = new Cliente(Integer.parseInt(cpf), nome,  login, senha, endereco, contato);
                ClienteServico.cadastrarCliente(cliente);
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static Cliente loginCliente(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite o login do cliente: ");
            String login = entrada.nextLine();
            System.out.println("Digite a senha do cliente: ");
            String senha = entrada.nextLine();
            Cliente clienteLogin = ClienteServico.loginCliente(login, senha);
            if(clienteLogin != null){
                System.out.println("Login realizado com sucesso!");
                return clienteLogin;
            }else{
                System.out.println("Login ou senha incorretos.");
                return null;
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
        return null;
    }

    public static void atualizarContaCliente(Cliente cliente){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Dados da sua conta:");
            System.out.println(cliente.toString());
            System.out.println("Deseja atualizá-la? (1)- Sim (0)- Não");
            String opcao = entrada.nextLine();
            if(opcao.equals("1")){
                System.out.println("Digite o nome do cliente: ");
                String nome = entrada.nextLine();
                System.out.println("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
                System.out.println("Digite o login do cliente: ");
                String login = entrada.nextLine();
                System.out.println("Digite a senha do cliente: ");
                String senha = entrada.nextLine();
                System.out.println("Digite o endereço do cliente: ");
                String endereco = entrada.nextLine();
                System.out.println("Digite o contato do cliente: ");
                String contato = entrada.nextLine();

                if(ClienteServico.verificarLogin(login) == false){
                    System.out.println("Login já existente, tente novamente.");
                }else{
                    cliente.setNomeCliente(nome);
                    cliente.setCpf(Integer.parseInt(cpf));
                    cliente.setLoginCliente(login);
                    cliente.setSenhaCliente(senha);
                    cliente.setEnderecoCliente(endereco);
                    cliente.setContatoCliente(contato);
                    ClienteServico.atualizarCliente(cliente);
                }
            }else{
                System.out.println("Operação cancelada.");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirContaCliente(Cliente cliente){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Dados da sua conta:");
            System.out.println(cliente.toString());
            System.out.println("Deseja excluí-la? (1)- Sim (0)- Não");
            String opcao = entrada.nextLine();
            if(opcao.equals("1")){
                ClienteServico.deletarCliente(cliente.getCpfCliente());
            }else{
                System.out.println("Operação cancelada.");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    // OPÇÕES GERENTE /////////////////////////////////////////////////////////////////

    public static void cadastroGerente(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite o nome do gerente: ");
            String nome = entrada.nextLine();
            System.out.println("Digite o login do gerente: ");
            String login = entrada.nextLine();
            System.out.println("Digite a senha do gerente: ");
            String senha = entrada.nextLine();

            if(FuncionarioServico.verificarLogin(login) == false){
                System.out.println("Login já existente, tente novamente.");
            }else{
                Gerente gerente = new Gerente(nome,  login, senha);
                FuncionarioServico.cadastrarGerente(gerente);
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static Gerente loginGerente(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite o login do gerente: ");
            String login = entrada.nextLine();
            System.out.println("Digite a senha do gerente: ");
            String senha = entrada.nextLine();
            Gerente gerenteLogin = FuncionarioServico.loginGerente(login, senha);
            if(gerenteLogin != null){
                System.out.println("Login realizado com sucesso!");
                return gerenteLogin;
            }else{
                System.out.println("Login ou senha incorretos.");
                return null;
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
        return null;
    }

    public static void atualizarContaGerente(Gerente gerente){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Dados da sua conta:");
            System.out.println(gerente.toString());
            System.out.println("Deseja atualizá-la? (1)- Sim (0)- Não");
            String opcao = entrada.nextLine();
            if(opcao.equals("1")){
                System.out.println("Digite o nome do gerente: ");
                String nome = entrada.nextLine();
                System.out.println("Digite o login do gerente: ");
                String login = entrada.nextLine();
                System.out.println("Digite a senha do gerente: ");
                String senha = entrada.nextLine();

                if(FuncionarioServico.verificarLogin(login) == false){
                    System.out.println("Login já existente, tente novamente.");
                }else{
                    gerente.setNomeGerente(nome);
                    gerente.setLoginGerente(login);
                    gerente.setSenhaGerente(senha);
                    FuncionarioServico.atualizarGerente(gerente);
                }
            }else{
                System.out.println("Operação cancelada.");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirContaGerente(Gerente gerente){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Dados da sua conta:");
            System.out.println(gerente.toString());
            System.out.println("Deseja excluí-la? (1)- Sim (0)- Não");
            String opcao = entrada.nextLine();
            if(opcao.equals("1")){
                FuncionarioServico.deletarGerente(gerente.getIdGerente());
            }else{
                System.out.println("Operação cancelada.");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    // OPÇÕES FUNCIONÁRIO //////////////////////////////////////////////////////////////////////

    public static void cadastroFuncionario(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Cargos cadastrados no sistema: ");
            System.out.println(FuncionarioServico.listarCargos());
            System.out.println("Digite o cargo escolhido para o funcionário: ");
            String cargo = entrada.nextLine();
            if(FuncionarioServico.converterCargo(Integer.parseInt(cargo)) == null){
                System.out.println("Cargo inválido, tente novamente.");
            }else{
                System.out.println("Digite o nome do funcionário: ");
                String nome = entrada.nextLine();
                System.out.println("Digite o telefone do funcionário: ");
                String telefone = entrada.nextLine();
                System.out.println("Digite o email do funcionário: ");
                String email = entrada.nextLine();
                System.out.println("Digite o salário inicial do funcionário: ");
                String salario = entrada.nextLine();

                Funcionario funcionario = new Funcionario(nome, telefone, email, FuncionarioServico.converterCargo(Integer.parseInt(cargo)), Double.parseDouble(salario));
                FuncionarioServico.cadastrarFuncionario(funcionario);
            }

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void atualizarFuncionario(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Funcionários cadastrados no sistema:");
            System.out.println(FuncionarioServico.listarFuncionario());
            System.out.println("Digite o ID do funcionário que deseja atualizar: ");
            String id = entrada.nextLine();
            Funcionario funcionario = FuncionarioServico.buscarFuncionarioPorId(Integer.parseInt(id));
            if(funcionario == null){
                System.out.println("ID inválido, tente novamente.");
            }else{
                System.out.println("Dados do funcionário:");
                System.out.println(funcionario.toString());
                System.out.println("Deseja atualizá-lo? (1)- Sim (0)- Não");
                String opcao = entrada.nextLine();
                if(opcao.equals("1")){
                    System.out.println("Digite o nome do funcionário: ");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o telefone do funcionário: ");
                    String telefone = entrada.nextLine();
                    System.out.println("Digite o email do funcionário: ");
                    String email = entrada.nextLine();
                    System.out.println("Digite o salário inicial do funcionário: ");
                    String salario = entrada.nextLine();

                    funcionario.setNomeFuncionario(nome);
                    funcionario.setTelefoneFuncionario(telefone);
                    funcionario.setEmailFuncionario(email);
                    funcionario.setSalarioFuncionario(Double.parseDouble(salario));
                    FuncionarioServico.atualizarFuncionario(funcionario);
                }else{
                    System.out.println("Operação cancelada.");
                }
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirFuncionario(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Funcionários cadastrados no sistema:");
            System.out.println(FuncionarioServico.listarFuncionario());
            System.out.println("Digite o ID do funcionário que deseja excluir: ");
            String id = entrada.nextLine();
            Funcionario funcionario = FuncionarioServico.buscarFuncionarioPorId(Integer.parseInt(id));
            if(funcionario == null){
                System.out.println("ID inválido, tente novamente.");
            }else{
                System.out.println("Dados do funcionário:");
                System.out.println(funcionario.toString());
                System.out.println("Deseja excluí-lo? (1)- Sim (0)- Não");
                String opcao = entrada.nextLine();
                if(opcao.equals("1")){
                    FuncionarioServico.deletarFuncionario(funcionario.getIdFuncionario());
                }else{
                    System.out.println("Operação cancelada.");
                }
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void listarFuncionarios(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Funcionários cadastrados no sistema:");
            System.out.println(FuncionarioServico.listarFuncionario());
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void listarFuncionarioPorCargo(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Cargos cadastrados no sistema: ");
            System.out.println(FuncionarioServico.listarCargos());
            System.out.println("Digite o cargo que deseja verificar: ");
            String cargo = entrada.nextLine();
            if(FuncionarioServico.converterCargo(Integer.parseInt(cargo)) == null){
                System.out.println("Cargo inválido, tente novamente.");
            }else{
                System.out.println("Funcionários cadastrados no sistema:");
                System.out.println(FuncionarioServico.listarFuncionarioPorCargo(FuncionarioServico.converterCargo(Integer.parseInt(cargo))));
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    // OPÇÕES PRODUTO /////////////////////////////////////////////////////////////////

    public static void cadastrarProduto(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void atualizarProduto(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirProduto(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void listarProdutos(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    // OPÇÕES PEDIDO /////////////////////////////////////////////////////////////////

    public static void fazerPedido(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void atualizarPedido(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirPedido(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void listarPedidos(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    // CLEAR BUFFER /////////////////////////////////////////////////////////////////

    public static void clearBuffer(Scanner scanner){
        if(scanner.hasNextLine()){
            scanner.nextLine();
        }
    }
}
