package Controllers;

import Banco.BaseDeDados;
import Models.Atendente;

public class AtendenteController {
    
    public static void adicionarAtendente(int codigo , String nome , String cpf , String tipo){
        // criei o objeto para ir para o banco
        Atendente a = new Atendente();
        
        // Preenchendo o objeto
        a.setCodigo(codigo);
        a.setNome(nome);
        a.setCpf(cpf);
        
        BaseDeDados.getAtendentes().add(a);
    }
    
    public static Atendente buscarPorCodigo(int codigo){
        
        for(Atendente a : BaseDeDados.getAtendentes()){
            if(a.getCodigo() == codigo){
                return a;
            }
        }
        return null;
    }

}
