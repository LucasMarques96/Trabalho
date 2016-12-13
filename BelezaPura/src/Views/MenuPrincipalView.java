package Views;

import Banco.BaseDeDados;
import java.util.Scanner;
import Views.ClienteView;
import Views.AtendenteView;
import Views.AtendimentoView;

public class MenuPrincipalView {
        
        ClienteView ClienteView = new ClienteView();
        AtendenteView AtendenteView = new AtendenteView();
        AtendimentoView AtendimentoView = new AtendimentoView();
        
        public static int inicio(){
            Scanner scan = new Scanner(System.in);
            
            System.out.println("");
            System.out.println("--------- SALÃO BELEZA PURA -------------");
            System.out.println("1 - Cliente");
            System.out.println("2 - Administrador");
            System.out.print("Digite a opção desejada: ");
            System.out.println("");
            
            int op = scan.nextInt();
            scan.nextLine();
            return op;
        }
        
        public void exibirMenu(){
            while (true) {
                int opcao = 0;
                do {
                    opcao = inicio();
                    switch(opcao){
                        case 1:
                            ClienteView.exibirMenuCliente();
                            break;
                        case 2:
                            AtendenteView.exibirMenuAtendente();
                            break;
                    }
                } while (opcao != 3);  
            }
        }
        
}
