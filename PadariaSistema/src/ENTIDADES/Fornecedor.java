package ENTIDADES;

public class Fornecedor {
    String CNPJ;
    String nomeFornecedor;
    String telefoneFornecedor;
    String emailFornecedor;
    String localFornecedor;

    public Fornecedor(String CNPJ, String nomeFornecedor, String telefoneFornecedor, String emailFornecedor, String localFornecedor){
        this.CNPJ = CNPJ;
        this.nomeFornecedor = nomeFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
        this.emailFornecedor = emailFornecedor;
        this.localFornecedor = localFornecedor;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }
    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }
    public String getEmailFornecedor() {
        return emailFornecedor;
    }
    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }
    public String getLocalFornecedor() {
        return localFornecedor;
    }
    public void setLocalFornecedor(String localFornecedor) {
        this.localFornecedor = localFornecedor;
    }

    public String toString(){
        String saida = "";
        saida += "CNPJ: " + this.CNPJ + "\t";
        saida += "Nome: " + this.nomeFornecedor + "\t";
        saida += "Telefone: " + this.telefoneFornecedor + "\t";
        saida += "Email: " + this.emailFornecedor + "\t";
        saida += "Local: " + this.localFornecedor + "\n";
        return saida;
    }
}
