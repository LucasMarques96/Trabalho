package Models;

public abstract class Pessoa {
    
    private String nome;
    
    private String cpf;


    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String value) {
        this.cpf = value;
    }     
    
}
