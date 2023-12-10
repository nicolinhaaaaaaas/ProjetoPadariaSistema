package ENTIDADES;

public class ForneceIngrediente {
    Fornecedor fornecedor;
    Ingrediente ingrediente;
    double precoIngrediente;
    String dataFornecimento;
    int quantidadeComprada;

    public ForneceIngrediente(Fornecedor fornecedor, Ingrediente ingrediente, double precoIngrediente, String dataFornecimento, int quantidadeComprada){
        this.fornecedor = fornecedor;
        this.ingrediente = ingrediente;
        this.precoIngrediente = precoIngrediente;
        this.dataFornecimento = dataFornecimento;
        this.quantidadeComprada = quantidadeComprada;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor= fornecedor;
    }
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    public double getPrecoIngrediente() {
        return precoIngrediente;
    }
    public void setPrecoIngrediente(double precoIngrediente) {
        this.precoIngrediente = precoIngrediente;
    }
    public String getDataFornecimento() {
        return dataFornecimento;
    }
    public void setDataFornecimento(String dataFornecimento) {
        this.dataFornecimento = dataFornecimento;
    }
    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }
    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public String toString(){
        String saida = "";
        saida += "Fornecedor: " + this.fornecedor + "\t";
        saida += "Ingrediente: " + this.ingrediente + "\t";
        saida += "Preço: " + this.precoIngrediente + "\t";
        saida += "Data: " + this.dataFornecimento + "\t";
        saida += "Quantidade: " + this.quantidadeComprada + "\n";
        return saida;
    }
}
