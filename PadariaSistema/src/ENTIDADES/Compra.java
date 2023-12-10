package ENTIDADES;

public class Compra {
    int idPedido;
    int idProduto;
    int quantidadeComprada;

    public Compra(int idPedido, int idProduto, int quantidadeComprada){
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidadeComprada = quantidadeComprada;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto= idProduto;
    }
    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }
    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public String toString(){
        String saida = "";
        saida += "ID Pedido: " + this.idPedido + "\t";
        saida += "ID Produto: " + this.idProduto + "\t";
        saida += "Quantidade Comprada: " + this.quantidadeComprada + "\n";
        return saida;
    }
}
