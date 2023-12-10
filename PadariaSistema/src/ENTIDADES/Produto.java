package ENTIDADES;

public class Produto {
    int idProduto;
    String nomeProduto;
    String descricaoProduto;
    double precoProduto;
    int quantidadeEstoque;
    
    public Produto(int idProduto, String nomeProduto, String descricaoProduto, double precoProduto, int quantidadeEstoque){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto(String nomeProduto, String descricaoProduto, double precoProduto, int quantidadeEstoque){
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getDescricaoProduto() {
        return descricaoProduto;
    }
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
    public double getPrecoProduto() {
        return precoProduto;
    }
    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String toString(){
        String saida = "";
        saida += "ID: " + this.idProduto + "\t";
        saida += "Nome: " + this.nomeProduto + "\t";
        saida += "Descrição: " + this.descricaoProduto + "\t";
        saida += "Preço: " + this.precoProduto + "\t";
        saida += "Quantidade em Estoque: " + this.quantidadeEstoque + "\n";
        return saida;
    }
}
