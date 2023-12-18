package SERVICOS;


import java.util.List;

import ENTIDADES.Fornecedor;
import ENTIDADES.Ingrediente;
import ENTIDADES.Produto;

public class ProdutoServico {
    public static void cadastrarProduto(Produto produto, List<Ingrediente> ingredientes){
        
    }

    public static void atualizarEstoqueProduto(int idProduto, int quantidade){
        
    }

    public static void atualizarProduto(Produto produto){
        
    }

    public static void deletarProduto(int idProduto){
        
    }

    public static String listarProduto(){
        
        return null;
    }

    public static String listarProdutoPorPreco(){

        return null;
    }  

    public static Produto buscarProdutoPorId(int idProduto){
            
            return null;
    }

    public static Produto buscarProdutoPorNome(String nomeProduto){
            
            return null;
    }

    // OPÇÕES INGREDIENTES /////////////////////////////////////////////////////////////////

    public static void cadastrarIngrediente(Ingrediente ingrediente){

    }

    public static void comprarIngrediente(Fornecedor fornecedor, int idIngrediente, int quantidade, double precoIngrediente, String data){

    }

    public static void atualizarEstoqueIngrediente(int idIngrediente, int quantidade){

    }

    public static void atualizarIngrediente(Ingrediente ingrediente){

    }

    public static void deletarIngrediente(int idIngrediente){

    }

    public static String listarIngrediente(){

        return null;
    }

    public static String listarIngredientePorFornecedor(String cnpjFornecedor){
            
            return null;
    }

    public static Ingrediente buscarIngredientePorId(int idIngrediente){

        return null;
    }

    public static Ingrediente buscarIngredientePorNome(String nomeIngrediente){

        return null;
    }

    // OPÇÕES FORNECEDOR /////////////////////////////////////////////////////////////////

    public static void cadastrarFornecedor(Fornecedor fornecedor, List<Ingrediente> ingredientes){

    }

    public static void atualizarFornecedor(Fornecedor fornecedor){

    }

    public static void deletarFornecedor(int idFornecedor){

    }

    public static String listarFornecedor(){

        return null;
    }

    public static Fornecedor buscarFornecedorPorCnpj(String cnpjFornecedor){

        return null;
    }

    public static Fornecedor buscarFornecedorPorNome(String nomeFornecedor){

        return null;
    }

}
