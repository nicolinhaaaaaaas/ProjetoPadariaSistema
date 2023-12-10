package ENTIDADES;

public class Funcionario {
    int idFuncionario;
    String nomeFuncionario;
    String telefoneFuncionario;
    String emailFuncionario;
    String cargoFuncionario;
    double salarioFuncionario;

    // Constructors
    public Funcionario(int idFuncionario, String nomeFuncionario, String telefoneFuncionario, String emailFuncionario, String cargoFuncionario, double salarioFuncionario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    public Funcionario(String nomeFuncionario, String telefoneFuncionario, String emailFuncionario, String cargoFuncionario, double salarioFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }
    // Getters
    public int getIdFuncionario() {
        return this.idFuncionario;
    }
    public String getNomeFuncionario() {
        return this.nomeFuncionario;
    }
    public String getTelefoneFuncionario() {
        return this.telefoneFuncionario;
    }
    public String getEmailFuncionario() {
        return this.emailFuncionario;
    }
    public String getCargoFuncionario() {
        return this.cargoFuncionario;
    }
    public double getSalarioFuncionario() {
        return this.salarioFuncionario;
    }
    // Setters
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }
    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }
    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }
    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public String toString(){
        String saida = "";
        saida += "ID: " + this.idFuncionario + "\t";
        saida += "Nome: " + this.nomeFuncionario + "\t";
        saida += "Telefone: " + this.telefoneFuncionario + "\t";
        saida += "Email: " + this.emailFuncionario + "\t";
        saida += "Cargo: " + this.cargoFuncionario + "\t";
        saida += "Salário: " + this.salarioFuncionario + "\n";
        return saida;
    }
}
