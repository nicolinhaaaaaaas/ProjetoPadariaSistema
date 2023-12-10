package ENTIDADES;

public class Gerente{
    int idGerente;
    String nomeGerente;
    String loginGerente;
    String senhaGerente;

    // Construtores
    public Gerente(int idGerente, String nomeGerente, String loginGerente, String senhaGerente){
        this.idGerente = idGerente;
        this.nomeGerente = nomeGerente;
        this.loginGerente = loginGerente;
        this.senhaGerente = senhaGerente;
    }

    public Gerente(String nomeGerente, String loginGerente, String senhaGerente){
        this.nomeGerente = nomeGerente;
        this.loginGerente = loginGerente;
        this.senhaGerente = senhaGerente;
    }
    
    // Getters
    public int getIdGerente(){
        return this.idGerente;
    }
    public String getNomeGerente(){
        return this.nomeGerente;
    }
    public String getLoginGerente(){
        return this.loginGerente;
    }
    public String getSenhaGerente(){
        return this.senhaGerente;
    }
    // Setters
    public void setIdGerente(int idGerente){
        this.idGerente = idGerente;
    }
    public void setNomeGerente(String nomeGerente){
        this.nomeGerente = nomeGerente;
    }
    public void setLoginGerente(String loginGerente){
        this.loginGerente = loginGerente;
    }
    public void setSenhaGerente(String senhaGerente){
        this.senhaGerente = senhaGerente;
    }

    public String toString(){
        String saida = "";
        saida += "ID: " + this.idGerente + "\t";
        saida += "Nome: " + this.nomeGerente + "\t";
        saida += "Login: " + this.loginGerente + "\t";
        saida += "Senha: " + this.senhaGerente + "\n";
        return saida;
    }
}
