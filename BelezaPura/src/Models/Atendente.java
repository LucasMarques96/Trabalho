package Models;

public class Atendente extends Pessoa {
    
    private int codigo;
    
    private String tipo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int value) {
        this.codigo = value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String value) {
        this.tipo = value;
    }

}

