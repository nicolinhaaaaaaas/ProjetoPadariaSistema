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
            System.out.println("Digite o nome do produto: ");
            String nome = entrada.nextLine();
            System.out.println("Digite a quantidade de ingredientes que esse produto levará: ");
            String quantidade = entrada.nextLine();
            List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
            int qtd = Integer.parseInt(quantidade);
            do{
                System.out.println("Digite o nome do ingrediente: ");
                String nomeIngrediente = entrada.nextLine();
                System.out.println("Digite a unidade de medida do ingrediente: ");
                String unidadeMedida = entrada.nextLine();
                System.out.println("Digite a quantidade utilizada do ingrediente: ");
                String quantidadeUtilizada = entrada.nextLine();
                Ingrediente ingrediente = new Ingrediente(nomeIngrediente, Integer.parseInt(quantidadeUtilizada), unidadeMedida);
                ingredientes.add(ingrediente);
                qtd--;
            }while(qtd > 0);
            System.out.println("Digite o preço do produto: ");
            String preco = entrada.nextLine();
            System.out.println("Digite uma breve descrição do produto: ");
            String descricao = entrada.nextLine();
            Produto produto = new Produto(nome, descricao, Double.parseDouble(preco), 0);
            ProdutoServico.cadastrarProduto(produto, ingredientes);
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

    // OPÇÕES FORNECEDOR /////////////////////////////////////////////////////////////////

    public static void cadastrarFornecedor(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite o nome do fornecedor: ");
            String nome = entrada.nextLine();
            System.out.println("Digite o CNPJ do fornecedor: ");
            String cnpj = entrada.nextLine();
            System.out.println("Digite o endereço do fornecedor: ");
            String endereco = entrada.nextLine();
            System.out.println("Digite o E-Mail do fornecedor: ");
            String email = entrada.nextLine();
            System.out.println("Digite o contato do fornecedor: ");
            String contato = entrada.nextLine();

            Fornecedor fornecedor = new Fornecedor(cnpj, nome, contato, email, endereco);

            System.out.println("Quantas matérias primas esse fornecedor provém?");
            String quantidade = entrada.nextLine();
            int qtd = Integer.parseInt(quantidade);

            List<Ingrediente> ingredientes = new ArrayList<>();
            do{
                System.out.println("Digite o nome da matéria prima: ");
                String nomeIngrediente = entrada.nextLine();
                System.out.println("Digite a unidade de medida da matéria prima: ");
                String unidadeMedida = entrada.nextLine();
                Ingrediente ingrediente = new Ingrediente(nomeIngrediente, 0, unidadeMedida);
                ProdutoServico.cadastrarIngrediente(ingrediente);
                ingredientes.add(ingrediente);
                qtd--;
            }while(qtd > 0);

            ProdutoServico.cadastrarFornecedor(fornecedor, ingredientes);
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void compraIngrediente(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Fornecedores cadastrados no sistema:");
            System.out.println(ProdutoServico.listarFornecedor());
            System.out.println("Digite o CNPJ do fornecedor que deseja comprar: ");
            String cnpj = entrada.nextLine();
            Fornecedor fornecedor = ProdutoServico.buscarFornecedorPorCnpj(cnpj);
            if(fornecedor == null){
                System.out.println("CNPJ inválido, tente novamente.");
            }else{
                System.out.println("Ingredientes fornecidos por essa empresa: ");
                System.out.println(ProdutoServico.listarIngredientePorFornecedor(fornecedor.getCNPJ()));
                int escolha = 1;
                do{
                    System.out.println("Digite o ID do ingrediente que deseja comprar: (0 para finalizar)");
                    String id = entrada.nextLine();
                    escolha = Integer.parseInt(id);
                    Ingrediente ingrediente = ProdutoServico.buscarIngredientePorId(escolha);
                    if(ingrediente == null){
                        System.out.println("ID inválido, tente novamente.");
                    }else{
                        System.out.println("Digite a quantidade que deseja comprar: ");
                        String quantidade = entrada.nextLine();
                        System.out.println("Digite o preço do ingrediente: ");
                        String preco = entrada.nextLine();
                        System.out.println("Digite a data da compra: ");
                        String data = entrada.nextLine();
                        ProdutoServico.comprarIngrediente(fornecedor, ingrediente.getIdIngrediente(), Integer.parseInt(quantidade), Double.parseDouble(preco), data);
                    }   
                }while(escolha != 0);
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }



    // OPÇÕES PEDIDO /////////////////////////////////////////////////////////////////

    public static void fazerPedido(Cliente cliente){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Produtos cadastrados no sistema:");
            System.out.println(ProdutoServico.listarProduto());
            System.out.println("Digite o ID do produto que deseja comprar: ");
            String id = entrada.nextLine();
            int escolha = Integer.parseInt(id);
            Produto produto = ProdutoServico.buscarProdutoPorId(escolha);
            if(produto == null){
                System.out.println("ID inválido, tente novamente.");
            }else{
                System.out.println("Digite a quantidade que deseja comprar: ");
                String quantidade = entrada.nextLine();
                System.out.println("Digite a data da compra: ");
                String data = entrada.nextLine();

                PedidoServico.fazerPedido(cliente.getCpfCliente(), );
            }
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
