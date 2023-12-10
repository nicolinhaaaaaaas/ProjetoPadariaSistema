package ENTIDADES;

public class Pedido {
    int idPedido;
    Cliente cliente;
    String statusPedido;
    double valorTotal;

    public Pedido(int idPedido, Cliente cliente, String statusPedido, double valorTotal){
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
    }

    public Pedido(Cliente cliente, String statusPedido, double valorTotal){
        this.cliente = cliente;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente= cliente;
    }
    public String getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String toString(){
        String saida = "";
        saida += "ID: " + this.idPedido + "\t";
        saida += "Cliente: " + this.cliente + "\t";
        saida += "Status: " + this.statusPedido + "\t";
        saida += "Valor Total: " + this.valorTotal + "\n";
        return saida;
    }
}
