package Controllers;

import Banco.BaseDeDados;
import Models.Cliente;

public class ClienteController {
    
    public static void adicionarCliente(int codigo, String nome, String cpf){
        // criei o objeto para ir para o banco
        Cliente c = new Cliente();
        
        // Preenchendo o objeto
        c.setCodigo(codigo);
        c.setNome(nome);
        c.setCpf(cpf);
        
        BaseDeDados.getClientes().add(c);
    }
    
    public static Cliente buscarPorCodigo(int codigo){
        
        for(Cliente c : BaseDeDados.getClientes()){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        
        return null;
    }

}

