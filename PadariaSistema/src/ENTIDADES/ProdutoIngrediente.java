package ENTIDADES;

public class ProdutoIngrediente {
    Produto produto;
    Ingrediente ingrediente;
    double quantidadeUsada;

    public ProdutoIngrediente(Produto produto, Ingrediente ingrediente, double quantidadeUsada){
        this.produto = produto;
        this.ingrediente = ingrediente;
        this.quantidadeUsada = quantidadeUsada;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto= produto;
    }
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    public double getQuantidadeUsada() {
        return quantidadeUsada;
    }
    public void setQuantidadeUsada(double quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }

    // toString
    public String toString(){
        String saida = "";
        saida += "Produto: " + this.produto + "\t";
        saida += "Ingrediente: " + this.ingrediente + "\t";
        saida += "Quantidade: " + this.quantidadeUsada + "\n";
        return saida;
    }
}
