package Banco;

import java.util.ArrayList;
import java.util.List;
import Models.Atendimento;
import Models.Cliente;
import Models.Atendente;

public class BaseDeDados {
    
    private static List<Cliente> cliente;
    private static List<Atendente> atendente;
    private static List<Atendimento> atendimento;

    public static List<Cliente> getClientes() {
        return cliente;
    }

    public static List<Atendente> getAtendentes() {
        return atendente;
    }

    public static List<Atendimento> getAtendimentos() {
        return atendimento;
    }
    
    public static void inicializarBaseClientes(){
       cliente = new ArrayList<Cliente>();
    }
   
    public static void inicializarBaseAtendentes(){
        atendente = new ArrayList<Atendente>();
    }
    
     public static void inicializarBaseAtendimentos(){
        atendimento = new ArrayList<Atendimento>();
    }
}