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
            Cliente clienteLogin = ClienteServico.loginCliente(login, senha)
            if(clienteLogin != null){
                System.out.println("Login realizado com sucesso!");
                return clienteLogin;
            }else{
                return null;
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void atualizarContaCliente(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirContaCliente(){
        Scanner entrada = new Scanner(System.in);

        try{

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

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void loginGerente(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void atualizarContaGerente(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirContaGerente(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(Exception e){
            System.out.println("Erro: " + e);
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
