package belezapura;

import Banco.BaseDeDados;
import Views.MenuPrincipalView;

public class BelezaPura {

    public static void main(String[] args) {
        
        BaseDeDados.inicializarBaseClientes();
        BaseDeDados.inicializarBaseAtendimentos();
        BaseDeDados.inicializarBaseAtendentes();
        
        MenuPrincipalView menu = new MenuPrincipalView();
        menu.exibirMenu();
       
    }
    
}
