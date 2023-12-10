package ENTIDADES;

public class Ingrediente {
    int idIngrediente;
    String nomeIngrediente;
    int quantidadeEstoque;
    String unidadeMedida;

    public Ingrediente(int idIngrediente, String nomeIngrediente, int quantidadeEstoque, String unidadeMedida) {
        this.idIngrediente = idIngrediente;
        this.nomeIngrediente = nomeIngrediente;
        this.quantidadeEstoque = quantidadeEstoque;
        this.unidadeMedida = unidadeMedida;
    }

    public Ingrediente(String nomeIngrediente, int quantidadeEstoque, String unidadeMedida) {
        this.nomeIngrediente = nomeIngrediente;
        this.quantidadeEstoque = quantidadeEstoque;

        this.unidadeMedida = unidadeMedida;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }
    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }
    public String getNomeIngrediente() {
        return nomeIngrediente;
    }
    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public String getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String toString(){
        String saida = "";
        saida += "ID: " + this.idIngrediente + "\t";
        saida += "Nome: " + this.nomeIngrediente + "\t";
        saida += "Quantidade: " + this.quantidadeEstoque + "\t";
        saida += "Unidade de Medida: " + this.unidadeMedida + "\n";
        return saida;
    }
}
