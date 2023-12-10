package MENU;

import java.util.*;

public class Menu {
    
    // OPÇÕES CLIENTE /////////////////////////////////////////////////////////////////

    public static void cadastroCliente(){
        Scanner entrada = new Scanner(System.in);

        try{
            
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void loginCliente(){
        Scanner entrada = new Scanner(System.in);

        try{

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
