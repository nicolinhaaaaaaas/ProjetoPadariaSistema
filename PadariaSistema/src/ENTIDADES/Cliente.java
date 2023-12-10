package ENTIDADES;

public class Cliente {
    int CpfCliente;
    String nomeCliente;
    String loginCliente;
    String senhaCliente;
    String enderecoCliente;
    String contatoCliente;
    
    // Constructors
    public Cliente(int CpfCliente, String nomeCliente, String loginCliente, String senhaCliente, String enderecoCliente, String contatoCliente) {
        this.CpfCliente = CpfCliente;
        this.nomeCliente = nomeCliente;
        this.loginCliente = loginCliente;
        this.senhaCliente = senhaCliente;
        this.enderecoCliente = enderecoCliente;
        this.contatoCliente = contatoCliente;
    }

    public Cliente(String nomeCliente, String loginCliente, String senhaCliente, String enderecoCliente, String contatoCliente) {
        this.nomeCliente = nomeCliente;
        this.loginCliente = loginCliente;
        this.senhaCliente = senhaCliente;
        this.enderecoCliente = enderecoCliente;
        this.contatoCliente = contatoCliente;
    }
    // Getters
    public int getCpfCliente() {
        return this.CpfCliente;
    }
    public String getNomeCliente() {
        return this.nomeCliente;
    }
    public String getLoginCliente() {
        return this.loginCliente;
    }
    public String getSenhaCliente() {
        return this.senhaCliente;
    }
    public String getEnderecoCliente() {
        return this.enderecoCliente;
    }
    public String getContatoCliente() {
        return this.contatoCliente;
    }
    // Setters
    public void setCpfCliente(int CpfCliente) {
        this.CpfCliente = CpfCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setLoginCliente(String loginCliente) {
        this.loginCliente = loginCliente;
    }
    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }
    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }
    public void setContatoCliente(String contatoCliente) {
        this.contatoCliente = contatoCliente;
    }

    // toString
    public String toString(){
        String saida = "";
        saida += "CPF: " + this.CpfCliente + "\t";
        saida += "Nome: " + this.nomeCliente + "\t";
        saida += "Login: " + this.loginCliente + "\t";
        saida += "Senha: " + this.senhaCliente + "\t";
        saida += "Endereço: " + this.enderecoCliente + "\t";
        saida += "Contato: " + this.contatoCliente + "\n";
        return saida;
    }

    
}
